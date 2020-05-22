private void getExponent(APDU apdu) {
    byte[] buffer = apdu.getBuffer();
    short length = m_publicKey.getExponent(buffer, ISO7816.OFFSET_CDATA);
    apdu.setOutgoingAndSend((short) 0, length); // not the valid public exp
}

private void getModulus(APDU apdu) {
    byte[] buffer = apdu.getBuffer();
    short length = m_publicKey.getModulus(buffer, ISO7816.OFFSET_CDATA);
    apdu.setOutgoingAndSend((short) 0, length); // not the valid mod
}