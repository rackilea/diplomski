package net;


public class Test {

    private String k;

    /**
     * 
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void set(String a, String b, String c) {
         k = a + " " + b + " " + c; //do something
    }

    public void run() {
        System.out.println(k);
    }

    public static void main(String[] args) {
        String l = args[0];
        String m = args[1];
        String n = args[2];
        Test obj = new Test();
        obj.set(l, m, n);
        obj.run();
    }
}