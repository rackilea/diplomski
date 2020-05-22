// NOTE: code not tested, but I believe this is valid java...
public class CommandExample 
{
    public interface Command 
    {
        public void execute(Object data);
    }

    public class PrintCommand implements Command 
    {
        public void execute(Object data) 
        {
            System.out.println(data.toString());
        }    
    }

    public static void callCommand(Command command, Object data) 
    {
        command.execute(data);
    }

    public static void main(String... args) 
    {
        callCommand(new PrintCommand(), "hello world");
    }
}