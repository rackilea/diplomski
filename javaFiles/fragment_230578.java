import javax.batch.api.chunk.ItemProcessor;

public class FooBar {

    private static ItemProcessor i = new ItemProcessor() {
        @Override
        public Object processItem(Object item) throws Exception {
            return item;
        }
    };

    public static void main(String[] args) {
        System.out.println("Foo");
    }
}