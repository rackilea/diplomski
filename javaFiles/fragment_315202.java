public String getMessage(byte[] bytes) {
    StringBuilder message = new StringBuilder(); 
    int index = 0
    while (index < bytes.length) {
        byte[] partOfMessage = Arrays.copyOfRange(bytes, index + 3, index + 7);
        message.append(new String(partOfMessage , StandardCharsets.UTF_8));
        index += 7;
    }
    return message.toString();
}