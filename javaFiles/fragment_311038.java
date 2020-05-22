private interface Printer {
    void print();
}

private static class A implements Printer {
    @Override
    public void print() {
        System.out.println("A");
    }
}

private static class B implements Printer  {
    @Override
    public void print() {
        System.out.println("B");
    }
}

public static void main(String[] args) {
    List<Printer> list = asList(new A(), new B(), new A());

    list.forEach(Printer::print);
}