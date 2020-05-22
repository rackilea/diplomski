class NewlineStringBuilder {

    private StringBuilder delegate;

    public NewlineStringBuilder() {
        delegate = new StringBuilder();
    }

    public NewlineStringBuilder appendLine(String str) {
        delegate.append(str).append("\n");
        return this;
    }

    public String toString() {
        return delegate.toString();
    }
}