class Test
{
    public Test() {
        Runnable r = new Runnable() {
            @Override public void run() {
                System.out.println(toString()); // toString on anonymous class
                System.out.println(Test.this.toString()); // toString on Test
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        new Test();
    }

    @Override public String toString() {
        return "Test.toString()";
    }
}