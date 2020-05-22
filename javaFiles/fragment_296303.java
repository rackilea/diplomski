public class BytecodeMods {

    public static void main(String[] args) throws Exception {
        byte[] code = disableMethod(BytecodeMods.class.getMethod("test"));
        new ClassLoader() {
            Class<?> get() { return defineClass(null, code, 0, code.length); }
        }   .get()
            .getMethod("test").invoke(null);
    }

    public static void test() {
        System.out.println("This is a test");
    }

    …