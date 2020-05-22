class Thing<T> {
}

class Test<T> {
    private Thing<T>[] array;

    @SuppressWarnings("unchecked")
    public Test(int sz) {
        array = (Thing<T>[]) new Thing[sz];
    }

    public static void main(String[] args) {
        Test<Object> test = new Test<>(1);
    }
}