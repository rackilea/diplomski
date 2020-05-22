Message message = (Your Message)
String messageBody = message.getBody();
Sender messageSender = message.getSender();

if(messageBody.startsWith("!")) {
    // Split the message after every space
    String[] commandParts = messageBody.split(" ");
    // The first element is the command base, like: !help
    String baseCommand = commandParts[0];
    // Remove the first character from the base, turns !help into help
    baseCommand = baseCommand.substring(1, baseCommand.length());
    // Creates a new array for the arguments. The length is smaller, because we won't copy the command base
    String[] args = new String[commandParts.length - 1];
    // Copy the elements of the commandParts array from index 1 into args from index 0
    if(args.length > 0) {
        System.arraycopy(commandParts, 1, args, 0, commandParts.length - 1);
    }
    // Your parse method
    processCommand(sender, baseCommand, args);
}

public void processCommand(Sender sender, String base, String[] args) {
    if(commandRegistry.containsKey(base)) {
        commandRegistry.get(base).execute(sender, args);
    } else {
        // Handle unknown command
    }
}

public abstract class AbstractCommand {
    public abstract void execute(Sender sender, String[] args);
}