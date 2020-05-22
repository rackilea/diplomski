public enum Magic {
       INSTANCE;
       private final String fooString = "Best way to implement Singleton";
       public void doSingletonMagic() {
           Magic.INSTANCE.doSomethingSimple();
           System.out.println(fooString);
       }
}