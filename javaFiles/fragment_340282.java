public class Test {
    public static void main(String[] args) {
        LoggerTemplate lt = new JitterBufferLogger();
        lt.writeToLog("Hello");
    }
}