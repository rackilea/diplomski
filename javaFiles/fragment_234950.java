new ByteBuddy().subclass(Object.class)
               .name("t.Foo")
               .constructor(any()).intercept(to(new Object() {
                 public void construct() throws Exception {
                   System.out.println("CALLING XTOR");
                 }
               }).andThen(SuperMethodCall.INSTANCE)) // This makes the difference!
               .make()
               .load(Bar.class.getClassLoader(), INJECTION)
               .getLoaded()