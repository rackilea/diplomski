class Foo {

   private final Bar bar;

   @Inject
   Foo(Bar bar) {
       this.bar = bar;
   }
}

class Bar {

    @Inject 
    Bar() {}
}

class Activity extends AppCompatActivity {

    @Inject Foo foo;

}