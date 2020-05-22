public static NdefRecord createTextRecord(String language, String text) {
    byte[] languageBytes;
    byte[] textBytes;
    try {
        languageBytes = language.getBytes("US-ASCII");
        textBytes = text.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
        throw new AssertionError(ex);
    }

    byte[] recordPayload = new byte[1 + (languageBytes.length & 0x03F) + textBytes.length];

    recordPayload[0] = (byte)(languageBytes.length & 0x03F);
    System.arraycopy(languageBytes, 0, recordPayload, 1, languageBytes.length & 0x03F);
    System.arraycopy(textBytes, 0, recordPayload, 1 + (languageBytes.length & 0x03F), textBytes.length);

    return new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, null, recordPayload);
}

NdefRecord r = createTextRecord("en", recordArr[1]);