public void someMethod() {
    ....
    { // nested block to limit the scope of 'test'
        int test = 6;
        if (test == 9) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}