/**
 * Activate this instance. After this call {@link #isActive()} will return {@code true}.
 */
protected final void activate(InputStream is, OutputStream os) {
    if (this.is != null) {
        throw new IllegalStateException("input was set already");
    }
    if (this.os != null) {
        throw new IllegalStateException("output was set already");
    }
    if (is == null) {
        throw new NullPointerException("is");
    }
    if (os == null) {
        throw new NullPointerException("os");
    }
    this.is = is;
    this.os = os;
}