@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Foo1 other = (Foo1) obj;
        if (!Arrays.equals(foo2_array, other.foo2_array))
            return false;
        return true;
    }