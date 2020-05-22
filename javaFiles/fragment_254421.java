public class Testing
{
private final static Logger logger = Logger.getLogger(Testing.class);
static
{
    PropertyConfigurator.configure("log4j.properties");
}
public static void main(String args[])
{
    Logger out = Logger.getLogger("SystemOut");
    Level info = Level.INFO;
    System.setOut(new PrintStream(new LoggingOutputStream(out, info),true));
    System.out.println("Entered main method...............");
    System.out.println("Printing 2nd...............");
}
}