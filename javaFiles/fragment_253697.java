public abstract class Base implements YourInterface {

  private YourInterface override;

  protected Base(YourInterface override) {
    this.override = (override == null) ? new BaseImplementation() : override;
  }

  @Override
  public final void methodOne() {
    override.methodOne();
  }

  @Override
  public final void methodTwo() {
    override.methodTwo();
  }

  // This is the default implementation
  private static class BaseImplementation implements YourInterface {

    @Override
    public void methodOne() {
      System.out.println("Original one.");      
    }

    @Override
    public void methodTwo() {
      System.out.println("Original two.");
    }    
  }
}