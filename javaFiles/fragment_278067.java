public class ExampleRunner implements Runnable
{
    int count;
    Button startBg;

    public ExampleRunner(int count, Button startBg) {
    this.count = count;
    this.startBg = startBg;
}