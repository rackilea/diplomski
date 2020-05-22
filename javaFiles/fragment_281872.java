class Child {
    private class ParentAImp implements ParentA {
      @Override
      public void display() {
          displayParentA();
      }
    }

    private class ParentBImp implements ParentB {
      @Override
      public int display() {
          return displayParentB(); 
      }
    }

    public ParentA asParentA(){ return new ParentAImp(); }
    public ParentB asParentB(){ return new ParentBImp(); }

    private void displayParentA() {
        System.err.println("Child ParentA");
    }

    private int displayParentB() {
        System.err.println("Child ParentB");
        return 0;
    }
}