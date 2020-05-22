public class Foo {
    private Bar hidden;
    private String accessible;
    private final Helper helper = new Helper();


    Helper helper() {
       return helper;
    }      

    class Helper {

        @Override
        public boolean equals( Object ob ) {
          // you can access "hidden" from here
        }

        @Override
        public int hashCode() {
          // you can access "hidden" from here
        }

        public Foo foo() {
            return Foo.this;
        }
    }
}