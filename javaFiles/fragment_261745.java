public static void main(String[] args) {
    MyContainer<Object> container = new MyContainer<Object>("hello!");
    String val = (String) container.get();
    System.out.println(val);
}

class MyContainer<T> {
    final Object value;

    MyContainer(Object value) {
        this.value = value;
    }

    Object get() {
        return value;
    }
}