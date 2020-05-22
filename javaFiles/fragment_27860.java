void sendMessage( SmppSession session,  String message) {

    try {
        byte[] textBytes = CharsetUtil.encode(message, CharsetUtil.CHARSET_UCS_2);

        DeliverSm deliver = new DeliverSm();

        deliver.setSourceAddress(new Address((byte)0x03, (byte)0x00, "40404"));
        deliver.setDestAddress(new Address((byte)0x01, (byte)0x01, "44555519205"));
        deliver.setShortMessage(textBytes);

        WindowFuture<Integer,PduRequest,PduResponse> future = session.sendRequestPdu(deliver, 10000, false);
        if (!future.await()) {
            logger.error("Failed to receive deliver_sm_resp within specified time");
        } else if (future.isSuccess()) {
            DeliverSmResp deliverSmResp = (DeliverSmResp)future0.getResponse();
            logger.info("deliver_sm_resp: commandStatus [" + deliverSmResp.getCommandStatus() + "=" + deliverSmResp.getResultMessage() + "]");
        } else {
            logger.error("Failed to properly receive deliver_sm_resp: " + future.getCause());
        }
    } catch (Exception e) {}
}