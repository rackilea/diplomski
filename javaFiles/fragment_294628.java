interface I {
  String method1();
  String method2();
  ...
  String methodN();
}

class IDoSomethingDecorator implements I {
  private final I contents;
  private final Runnable commonAction;

  IDoSomethingDecorator(I decoratee, Runnable commonAction){
    this.contents = decoratee;
    this.commonAction = commonAction;
  }

  String methodi() {
    this.commonAction().run();
    return contents.methodi();
  }
}