class DefaultExampleImpl implements Example {
   // Implements the methods
}

class YourClass extends YetAnotherClass implements Example {
    private Example example = new DefaultClassImpl();

    @Override
    public void method1() {
          this.example.method1();
    }

    @Override
    public String method2(final int parameter) {
          return this.example.method2(parameter);
    }
}