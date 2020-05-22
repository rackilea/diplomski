public static void main( String[] args ){
            doSomething1();
            System.out.println("Now do 2");
            doSomething2();
            System.out.println("native java");
            doSomethingJava();

            String s = "test";
            synchronized ( s ){
                    int x = 9 + 5;
            }
    }

    public static native void doSomething1();
    public static synchronized native void doSomething2();

    public static synchronized void doSomethingJava(){
            System.out.println("synchronized");
    }