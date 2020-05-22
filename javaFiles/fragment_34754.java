public abstract class Bob extends BobsMom{
      @Override
      abstract void methodToOverride(); // Force subclass to override
  }

  //Subclass
  public class BobKid extends Bob{
      @Override
      void methodToOverride(){

      }
  }