public abstract class Command {   

    public Command() {
        // Do things to initialize Command
    }    
}

public abstract class ComplexCommand extends Command {

    private ArrayList<String> commands;

    public ComplexCommand() {
        super();
        // Do things to initialize ComplexCommand
        this.commands = new ArrayList<>();
        System.out.println(this.commands);
    }    
}

public class MyTestCommand extends Command {

    public MyTestCommand() {
        super();
        setUsage("Usage: /test <target>");
        setDescription("This is a test command");
    }    
}