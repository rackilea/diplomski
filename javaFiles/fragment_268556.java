public static void main(String[] args) {
    Gson gson = new Gson();

    //Sender side
    Message message = new Message();
    message.setA(true);
    message.setD("Hello World");

    String messageAsJson = gson.toJson(message);
    //write messageAsJson to socket
    System.out.println(messageAsJson);



    //Receiver side, reads line from socket and decodes
    Message decodedMessage = gson.fromJson(messageAsJson, Message.class);
    System.out.println(decodedMessage.getA());
    System.out.println(decodedMessage.getD());
}


public static class Message {
    private Boolean a;
    private String d;
    public Boolean getA() {
        return a;
    }
    public void setA(Boolean a) {
        this.a = a;
    }
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }

}