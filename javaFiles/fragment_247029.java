private Class<E> clazz;

public Test(Class clazz) {
    this.clazz = clazz;
}

public void addElement (Object node) {
    list.add(clazz.cast(node));
}

public static void main(String[] args) {
    Test<String> test = new Test(String.class);
    test.addElement("test");
    test.addElement(Integer.intValue(10));
}