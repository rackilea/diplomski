ByteBuffer payloadByteBuffer = invokeResult.getPayload();
byte[] payloadByteArray = payloadByteBuffer.array();
rawJson = new String(payloadByteArray, Charset.forName("UTF-8"));

JSONParser parser = new JSONParser();
try {
        JSONObject json = (JSONObject) parser.parse(rawJson);
} catch (ParseException e) {
    e.printStackTrace();
}