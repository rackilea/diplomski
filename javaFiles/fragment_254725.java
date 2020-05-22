public class OuterClass{

    public class InnerClass{
        private int privateProperty= -2;
        static int access$002(InnerClass obj, int value) {
            obj.privateProperty = value;
            return value;
        }
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        InnerClass ic = oc.new InnerClass();
        InnerClass.access$002(ic, -98);
    }
}