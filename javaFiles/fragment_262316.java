class StringPair {
    private final String str1, str2;

    public StringPair(final String str1, final String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public String getStr1() {
        return str1;
    }

    public String getStr2() {
        return str2;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StringPair))
            return false;

        StringPair sp = (StringPair) o;
        return Objects.equals(str1, sp.str1) && Objects.equals(str2, sp.str2);
    }

    @Override
    public int hashCode() {
        return Arrays.asList(str1, str2).hashCode();
    }
}