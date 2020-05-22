class MyClass {
    private int hash;

    public int hashcode() {
        int hash = this.hash;
        if (hash == 0) {
            hash = calculateIt();
            this.hash = hash;
        }
        return hash;
    }
}