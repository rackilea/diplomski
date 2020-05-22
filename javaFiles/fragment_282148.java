public class driver
{
    public static void main(String[] args)
    {
        for(int i = 1; i <=10; i++)
        {
            command c = new command("call" + i, "execute" + i);
        }

        for(command cmd: command.commands)
        {
            System.out.println(cmd);
        }
    }
}