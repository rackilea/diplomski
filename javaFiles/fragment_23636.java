public class Sq {

    private int number = 0;

    class Inner {
        private int a;

        private Inner(int a1) {
            this.a = a1;
            number++;
        }

        private String getOuterClassString()
        {
            return getOuterString();
        }

        private String getPrivateString()
        {
            return "privateString";
        }

        public String getPublicString()
        {
            return "publicString";
        }
    }

    private String getOuterString()
    {
        return "outerString";
    }

    public static void main(String[] args) {
        Sq outter = new Sq();
        Inner d = outter.new Inner(3);
        System.out.println("Number = " + outter.number);
        System.out.println("Private a = " + d.a);
        System.out.println("Number = " + outter.number);

        System.out.println(d.getPrivateString());
        System.out.println(d.getPublicString());
        System.out.println(d.getOuterClassString());
    }
}