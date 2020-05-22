interface CommonAction {
  void doSomething();
}
class DefaulCommonAction implements CommonAction {
  public void doSomething() { 
    /* do something here -
     * this is the duplicate code from Employee 1 and 2 
     */
  }
}

class HRAction {}
class ManagerAction {}

class Employee1Action extends HRAction {
  private CommonAction action;
  public Employee1Action (CommonAction action){
    this.action = action;
  }
  // delegate operations
  public void doSomething() {
    action.doSomething();
  }
}
class Employee2Action extends ManagerAction {
  // the same delegation here
}