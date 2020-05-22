public int compareTo(MyClass other) {
    if (this == other) {
        return 0;
    } else {
        int c = foo.CompareTo(other.foo)
        if (c == 0) {
            // what here?
        } else {
            return c;
        }
    }
}