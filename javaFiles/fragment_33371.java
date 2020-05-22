abstract class AbstractCoolness {
  private isCool;

  public AbstractCoolness(bool iscool){
     isCool = iscool;
  } 

  public boolean isCool() {
      return this.isCool;
  }
}

class CoolPerson extends AbstractCoolness {
   public CoolPerson() {
     super(true);
   }
}