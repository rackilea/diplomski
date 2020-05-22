public class MyLogger
{

    public static void write(String message){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        Logger.getLogger(stackTraceElements[2].getClassName()).info(message);
    }

    public static void main(String[] args){
        ClassA.log();
        ClassB.log();
    }
}