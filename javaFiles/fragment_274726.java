private String[] params = {"1", "2", "3"};

public String[] getParams() {
    return params;
}

public boolean testForEquality(String... param) {
    return Arrays.equals(getParams(), param);
}