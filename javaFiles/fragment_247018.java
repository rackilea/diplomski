@Command(name = "main-command",
        description = "Description of a main command",
        mixinStandardHelpOptions = true,
        subcommands = {HttpApp.class, CliCommandOne.class})
public class Application implements Runnable {

    @Override
    public void run() {
        System.out.println("hello from CLI main command");
    }

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(Application.class, args);
    }
}