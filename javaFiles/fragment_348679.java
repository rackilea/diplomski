class StringWrapper{
    final String s;
    public StringWrapper(String s){
        this.s=s;
    }
    @Override
    public String toString() {
        return s;
    }
}

final JComboBox cb = new JComboBox(new StringWrapper[]{ 
            new StringWrapper(null), 
            new StringWrapper("one"),
            new StringWrapper("two"),
            new StringWrapper("three")});