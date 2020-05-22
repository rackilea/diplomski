class Box<T> {
    private T t;

    public Box(T t) {
        this.t = t;
    }

    public void put(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

Box<?> box = new Box<String>("abc");
Object o = box.get(); // no problem
box.put(new Object()); // fail