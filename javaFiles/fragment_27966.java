public void save(int value) {
    try {
        super.save(value);
    } catch (ArrayStoreException x) {
        expand();
        try {
            super.save(value);
        } catch (ArrayStoreException x) {
            throw new IllegalStateException("Cannot save after expansion");
        }
    }
}