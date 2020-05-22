int getIntFrom8Bit2Complement(GroupAddress groupAddress) throws KNXException, InterruptedException {

    final Datapoint dp = new StateDP(groupAddress, "my datapoint "+groupAddress.toString());
    dp.setDPT(0, DPTXlator8BitSigned.DPT_VALUE_1_UCOUNT.getID());
    String result = processCommunicator.read(dp);
    try {
        return Integer.parseInt(result);
    } catch (NumberFormatException e) {
        throw new KNXException("Error Parsing 8 bit 2 complement result as int -- result = "+result);
    }
}