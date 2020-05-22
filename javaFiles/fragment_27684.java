final MimeMessageParser parser = new MimeMessageParser(message);
String body = null;
try {
    parser.parse();
} catch (Exception e) {
    LOG.error("Exception during parsing the message body: {}", e);
}
if (parser.hasPlainContent()) {
    body = parser.getPlainContent();
} else if (parser.hasHtmlContent()) {
    body = parser.getHtmlContent();
}