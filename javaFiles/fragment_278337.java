static class MyModule extends AbstractModule {
     @Override protected void configure() {
       TypeListener listener = new MyTypeListener(getProvider(Foo.class));
       bindListener(Matchers.any(), listener);
     }
   }