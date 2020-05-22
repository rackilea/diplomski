public class OuterClass {
    private int field;

    public OuterClass(int field) {
        this.field = field;
    }

    class InnerClass {
        public int getOuterClassField() {
            // we can access the field from the surrounding type's instance!
            return OuterClass.this.field;
        }
    }

    public static void main(String[] args) throws Exception {
        OuterClass parent = new OuterClass(42);

        // prints '42'
        System.out.println(parent.new InnerClass().getOuterClassField());

        // cannot work as it makes no sense
        // System.out.println(new InnerClass().getOuterClassField());
    }
}