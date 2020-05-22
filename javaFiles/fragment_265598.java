class PreDestroyPostConstruct {

  PreDestroyPostConstruct() {
    System.out.println("constructor");
  }

  {
    System.out.println("initialization block");
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("finalize");
  }
}