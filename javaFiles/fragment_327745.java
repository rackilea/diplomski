public void createMessage(MessageType messageType, String message) {
    String output = "";
    switch(messageType) {
    case INSTRUCTION:
        output = "INSTRUCTION: " + message + "\n";
        //edits required for an instruction
        break;  
    case ERROR:
        output = "ERROR: " + message + "\n";
        //edits required for an error
        break;    
    case SUCCESS:
        output = "SUCCESS: " + message + "\n";
        //edits required for a success
        break;    
    default:
        throw new IllegalArgumentException("Invalid message type: " + messageType);
    }
}