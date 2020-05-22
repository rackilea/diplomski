public class B {
    private static B _instance;
    public static B getInstance() {
        if (_instance == null) {
            _instance = new B(new A());
        }
        return _instance;
    }

   private A _a;

   private B (A a) {
       _a = a;
       _a.configure();
   }
}