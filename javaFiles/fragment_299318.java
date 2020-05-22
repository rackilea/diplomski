public Rectangle(Rectangle source) {
     this(checkNotNull(source, "Source cannot be null").width, source.height);
}

private static <T> T checkNotNull(T t, String msg) {
    if (t == null) throw new IllegalArgumentException(msg);
    return t;
}