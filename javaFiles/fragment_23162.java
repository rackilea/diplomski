public class Foo {

    private String a;

    public Foo(String a) {
        this.a = a;
    }

    public Object getStr() {
        return a;
    }


    public static void main(String[] args) {
        List<Foo> l = Arrays.asList(new Foo("a"), new Foo("b"));
        Assert.assertThat(l, contains(hasProperty("str", equalTo("a")),
                                      hasProperty("str", equalTo("b"))));
    }

}