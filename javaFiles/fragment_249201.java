public void someMethod() {
    {
        int x = 10;
        System.out.println(x); // Ok
    }
    System.out.println(x); // Error, x not visible here
}