interface IFactory {
  void run();
  String getResult();
}

class Workflow1Adapter implements IFactory {
  Workflow1 wf1 = new Workflow1();

  public void run() {
    wf1.doSomething();
  }

  public String getResult() {
    wf1.doAnother();
  }
}

class Workflow2Adapter implements IFactory {
  Workflow2 wf2 = new Workflow2();

  public void run() {
    wf2.doThatThing();
  }

  public String getResult() {
    wf2.doReturn();
  }
}

class Workflow1 {
  public void doSomething() {}
  public String doAnother() {}
}

class Workflow2 {
  public void doThatThing() {}
  public String doReturn() {}
}