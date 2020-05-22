public class Program {

    public static void main(String[] args) {
        MyEventMarshaller instance = new MyEventMarshaller();

        instance.subscribeMessage("yep", (a,b) -> MessageFormat.format("{0}/{1}", a, b));

        instance.marshallLoop();
    }
}