channel.retrieveMessageById(id).queue((message) -> {
// use the message here, its an async callback
    message.addReaction(reaction).queue();
    message.editMessage("bleh").queue();
    System.out.println("Message Content: " + message.getContentDisplay());
}, (failure) -> {
// if the retrieve request failed this will be called (also async)
    if (failure instanceof ErrorResponseException) {
        ErrorResponseException ex = (ErrorResponseException) failure;
        if (ex.getErrorResponse() == ErrorResponse.UNKNOWN_MESSAGE) {
            // this means the message doesn't exist
            channel.sendMessage("That message doesn't exist!").queue();
        }
    }
    failure.printStackTrace();
});