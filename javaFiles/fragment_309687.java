@Override
public void remove(final E value) {
    remove(value, new Tester<E>() {
        public boolean test(E testObj) {
            return true;
        }
    });
}