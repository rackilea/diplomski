public enum TestEnum {
    TEST1("test1"), TEST2("test2");

    private String name;
    TestEnum(String name) {
        this.name= name;
    }
    public String getName(){
        return name;
    }
    public static TestEnum fromName(String name) {
        for (TestEnum e: values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Name not found: " + name);
    }
}