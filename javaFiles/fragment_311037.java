private static class A {
    private void printA() {
        System.out.println("A");
    }
}

private static class B {
    private void printB() {
        System.out.println("B");
    }
}

public static void main(String[] args) {
    List<Object> list = asList(new A(), new B(), new A());

    list.forEach(element -> { // this is bad, don't do it!
        if (element instanceof A) {
            ((A) element).printA();
        }
        if (element instanceof B) {
            ((B) element).printB();
        }
    });
}