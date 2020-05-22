static class A {
    int x = 1;
}

public static void main(String[] args) throws Exception {
    System.out.println(getField(new A(), "x"));
}