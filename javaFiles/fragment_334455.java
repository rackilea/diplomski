public class StreamTest2 {

    public static void main(String[] args) {

        Stream.of(1, 2, 3).collect(TestList::new, TestList::add, TestList<Integer>::addAll);
        Stream.of(1, 2, 3).collect(TestList::new, TestList::add, TestList<Integer>::addAll2);
        Stream.of(1, 2, 3).collect(TestList::new, TestList::add, TestList<Integer>::addAll3);
        Stream.of(1, 2, 3).collect(TestList::new, TestList::add, TestList<Integer>::addAll4);
        Stream.of(1, 2, 3).collect(TestList::new, TestList::add, TestList<Integer>::addAll5);
        Stream.of(1, 2, 3).collect(TestList::new, TestList::add, TestList<Integer>::addAll6);

    }
}

class TestList<T> extends AbstractList<T> {

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return true;
    }

    public boolean addAll2(TestList<? extends T> c) {
        return true;
    }
    public boolean addAll3(Collection<T> c) {
        return true;
    }

    public boolean addAll4(List<? extends T> c) {
        return true;
    }
    public boolean addAll5(AbstractList<? extends T> c) {
        return true;
    }

    public boolean addAll6(Collection<? extends T> c) {
        return true;
    }

    @Override
    public boolean add(T e) {
        return true;
    }
}