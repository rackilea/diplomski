InvokeState is = InvokeState.getCurrentState();
byte[] bytesIn = (byte[])is.getPrivateData("$msgBytesIn");
String body = null;
if (bytesIn!=null) {
    body = new String(bytesIn, StandardCharsets.UTF_8);
}
// body now contains the request body