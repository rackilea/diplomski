public class Exceptions {
    public static void main(String[] args) {
        Exception r = new RuntimeException("Some message");
        throw new RuntimeException("Some other message", r);
    }
}