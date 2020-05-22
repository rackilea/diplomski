/*the Command interface*/
public interface ICommand {
    void execute(String[] commandArr);
}

public class Message implements ICommand {
    void execute(String[] commandArr) {
        int target = Integer.parseInt(commandArr[1]);
        String message = commandArr[2];
        MachatServer.sendMessage(target, this.conId, message);
    }
}

//same type of class for other commands

public class CommandManager {
    public ICommand getCommand(String commandName) {
        //store all the commands in a hashtable. 
        //Pull them out by name as requested.
    }

    //Esko's suggestion from comments
    public static void executeImmediately(String[] commandArr) {
        getCommand(commandArr[0]).execute(commandArr);
    }
}


public void handleParsedCommand(String[] commandArr) {

    ICommand command = CommandManager.getCommand(commandArr[0]);
    command.execute(commandArr);

//or Esko

    CommandManager.executeImmediately(commandArr);

}