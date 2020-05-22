// main class
class HelloWorld {
    public static void main(String[] args) {
        OuterClass ob = new OuterClass();
        OuterClass.InnerClass ob1 = ob.new InnerClass();
        ob = null;
        // ob1=null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ob1.innerMeth(); // you will get NPE here
    }
}