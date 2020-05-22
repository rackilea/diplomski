public class TestS1 {

    public abstract class Client {

        protected void synchronize() throws NoSuchMethodException {
            // How can I get the Annotation defined on inheriting class?
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement lastStackElement = stackTraceElements[2];