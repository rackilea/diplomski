public String createRequest(String message){
    System.out.println("Inside createRequest : "+ message);
    return message;
}


public Message processRequest(Message message){
    System.out.println("Inside process Request : " + message);
    return message;
}