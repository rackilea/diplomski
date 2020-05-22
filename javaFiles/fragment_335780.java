class StringKey {
    private String str1;
    private String str2;

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof StringKey) {
            StringKey s = (StringKey)obj;
            return str1.equals(s.str1) && str2.equals(s.str2);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (str1 + str2).hashCode();
    }
}