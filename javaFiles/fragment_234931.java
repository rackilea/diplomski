public class Box {
    public Object o;

    public void mutate() {
        o = new Object();
    }

    public static void main(String... args) throws IOException {
        ClassReader cr = new ClassReader(Box.class.getName());
        ASMifierClassVisitor acv = new ASMifierClassVisitor(new PrintWriter(System.out));
        cr.accept(acv, 0);
    }
}