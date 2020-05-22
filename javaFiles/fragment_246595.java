public static class Foo {
    public String a = "1";
    public String b = "2";
    private String c = "3";

    @JsonIgnore
    public String getC() { return c; }

    @JsonProperty // only necessary with Jackson 2.x
    public String setC(String c) { this.c = c; }
}