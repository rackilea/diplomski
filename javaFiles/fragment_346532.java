public final class String {
    private char[] value;

    public String(char[] value) {
        this.value = value.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof String))
            return false;
        String other = (String) obj;
        return Arrays.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    public char[] toCharArray() {
        return this.value.clone();
    }

    public String substring(int beginIndex, int endIndex) {
        return new String(Arrays.copyOfRange(this.value, beginIndex, endIndex));
    }

    // more utility methods

}