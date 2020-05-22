public class GenericTest {

    public static void main(final String[] args) {
        final GenericTest test = new GenericTest();
        String data = test.echo();
    }

    public <T> T echo() {
        return null;
    }
}