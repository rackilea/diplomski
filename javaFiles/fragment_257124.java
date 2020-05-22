public static class Obj {
    public int i;

    public Obj(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Obj) || other == null) return false;
        return i == ((Obj)other).i;
    }

    @Override
    public int hashCode() {
        return i;
    }
}