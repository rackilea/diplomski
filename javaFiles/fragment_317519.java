// suppose 'message' is an object of type Message
String contentType = message.getContentType();

if (contentType.contains("multipart")) {
    // this message may contain attachment
}