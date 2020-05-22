class Fixed {
    private int size;
    private int[] store;
    private int index = 0;

    public Fixed(int size) {
        this.size = size;
        store = new int[size];
    }

    public void save(int value) throws ArrayStoreException {
        if (index == size)
            throw new ArrayStoreException();
        store[index++] = value;
    }

    protected void expand() {
        size *= 2;
        store = Arrays.copyOf(store, size);
    }
}

class Expandable extends Fixed {
    public void save(int value) {
        try {
            super.save(value);
        } catch (ArrayStoreException x) {
            expand();
            save(value);
        }
    }
}