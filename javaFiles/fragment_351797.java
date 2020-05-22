private String foo = "0";

public String getFoo() {
    return foo;
}

public void setFoo(String foo) {
    if (foo != null && !foo.isEmpty()) { // Or StringUtils.isNotBlank(foo)
        this.foo = foo;
    }
}