private void getExponent(APDU apdu) {
    byte[] buffer = apdu.getBuffer();
    short length = m_publicKey.getExponent(buffer, (short) 0);
    apdu.setOutgoingAndSend((short) 0, length);
}

private void getModulus(APDU apdu) {
    byte[] buffer = apdu.getBuffer();
    short length = m_publicKey.getModulus(buffer, (short) 0);
    apdu.setOutgoingAndSend((short) 0, length);
}