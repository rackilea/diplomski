public EmailInfo blEmailInfo() {
    EmailInfo info = new EmailInfo();
    info.setFromAddress("");
    info.setSendAsyncPriority("2");
    info.setSendEmailReliableAsync("false");
    return info;
}