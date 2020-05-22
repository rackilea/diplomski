class Parent<T> {
    int parentVal
}

class Child1 extends Parent<Child1> {
    def value1;
}

class Child2 extends Parent<Child2> {
    def value2;
}

class MyCollection<T extends Parent<T>> {
    def list = new ArrayList<T>()

    void add(T item) throws Exception {
      list.add(item);
    }

    T getItem(int index) {
        return list.get(index);
    }
}