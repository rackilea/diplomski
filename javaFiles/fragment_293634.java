public class FooBar extends Bar {
    public Foo<String> adapt() {
        return new Foo<String>() {
            public void setValue(String value) {
                FooBar.this.setValue( value );
            }
        }
    }
}