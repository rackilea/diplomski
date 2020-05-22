public static void main(String[] args) {
    MyContainer container = new MyContainer("hello!");
    String val = container.get();
    System.out.println(val);
}

class MyContainer {
    final Object value;

    MyContainer(Object value) {
        this.value = value;
    }

    Object get() {
        return value;
    }
}