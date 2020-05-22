abstract class A {
   abstract public boolean login(String...args);    
}
class B extends A {
   public boolean login(String...args) { return this.login(args[0], args[1]); }
   public boolean login(String user, String pass) { return original.login(user,pass); }
}

class C {
   public void login() {
      B b = new B();
      b.login("foo", "secret");
      // or
      b.login(new String[] {"foo", "secret"});
      // or !
      b.login("foo", "secret", "sessionId");  // will ignore third, but otherwise would still work...
   }
}