private static int x = 0;

public static void main(String[] args) throws ParseException {
    int x = 0;
    doSomething(x);
    doSomething(x);
    doSomething(x);
    doSomething(x);
    doSomething(x);
}

private static void doSomething(int x) {
    System.out.println(x++);
}