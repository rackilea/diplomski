@Path("/message")
    @Consumes(MediaType.APPLICATION_JSON)
public MessengerDatabase ddMessage(Message message){

MessengerDatabase mes = new MessageService().addMessage(message);

return mes;