public class Test {

    public void method(){

        Innerclass ic = new Innerclass();
        InnerClass2 ic2 = new InnerClass2();
        System.out.println(ic.i);
        System.out.println(ic.j);
        System.out.println(ic.k);
        System.out.println(ic.l);

        System.out.println(ic2.i);  // Compile Error
        System.out.println(ic2.j);
        System.out.println(ic2.k);
        System.out.println(ic2.l);
    }

    private class Innerclass{

        private int i;
        public int j;
        protected int k;
        int l;

    };

    private class InnerClass2 extends Innerclass{

    }

}