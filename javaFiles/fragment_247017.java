@Command(name = "cli-one", description = "test cli command one")
public class CliCommandOne implements Runnable {
    @Override
    public void run() {
        System.out.println("hello from CliCommandOne");
    }
}