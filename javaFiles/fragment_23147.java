public static void main(String[] args) {

    class SubA extends A {
        @Override
        public void m() {
            System.out.println("Override - > m()");
            new Thread(new Runnable() {

                @Override
                public void run() {
                    SubA.super.m();
                 // ^^^^ we now have a name of the directly enclosing class
                }
            }).start();
        }
    }
    A a = new SubA();
    a.m();
}