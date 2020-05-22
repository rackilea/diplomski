private transient String path;  // null ==> opaque

// ...

public boolean isOpaque() {
    return path == null;
}