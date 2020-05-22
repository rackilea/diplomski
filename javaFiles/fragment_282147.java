import java.util.List;
import java.util.ArrayList;
public class command
{

    String call;
    String execute;

    public static List<command> commands = new ArrayList<>();

    public command() {
        commands.add(this);
    }

    public command(String call, String execute)
    {
        this.call = call;
        this.execute = execute;
        commands.add(this);
    }

    public String toString() 
    { 
        return "call: " + call + " | execute: " + execute;
    } 

}