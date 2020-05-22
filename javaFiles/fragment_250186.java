class Test {
    public void method(ArrayList list) {
    }
}

class TestSub extends Test {

    @Override
    public void method(ArrayList list) {
    //                 ^^^^^^^^^
    //     Complain on use of raw type or not?

        System.out.println("Overridden");
    }
}