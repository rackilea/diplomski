public boolean foo(int i) {
    if (i > 0) {
        return true;   // Multiple exit points
    }
    return false; // ~ ~ ~
}

public boolean bar(int i) {
    boolean bool = false;
    if (i > 0) {
        bool = true;
    }
    return bool;   // Single exit points
}