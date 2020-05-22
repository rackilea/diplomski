public class TestEclipseJVMDebugger {

    public static void main(String[] argc) {

        Integer i1 = new Integer(27);
        int i2 = 7;

        assert (-128 <= i1 && i1 <= 127);
        assert (-128 <= i2 && i2 <= 127);

        System.out.println("i1 = " + i1);
        i1 = Integer.valueOf(i2);
        System.out.println("i1 = " + i1);

        System.out
                .println("apply debug point here and change value of primitive data type of i1 to 666 from debug mode");
        System.out.println("i1 = " + i1);
        i1 = Integer.valueOf(i2);
        System.out.println("i1 = " + i1);

    }

}