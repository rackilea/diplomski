class Foo {
    Foo() throws InterruptedException {
        while (true) {
            System.out.println("not returning yet ...");
            Thread.sleep(2000);
        }
    }
    public static void main(String[] args) throws InterruptedException {
         Foo foo = new Foo();
    }
}