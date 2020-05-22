public class Box{
  public BoxColor getColor(){}
  public void recolor(BoxColor color){} 
}

public class BoxFactory{
    public Box createDefaultBox(SomeDate date){
         NewBoxPolicy boxPolicy = PolicyRegistry.getNewBoxPolicyForDate(date);
         Box box = new Box();
         boxPolicy.prepareBox(box);
         return box;
   }
}
public interface NewBoxPolicy{
   void prepareBox(Box box);
}
public class FebruaryNewBoxPolicy implements NewBoxPolicy{
    public void prepareBox(Box box) { box.recolor(BoxColor.RED}; }
}
public class JanuaryNewBoxPolicy implements NewBoxPolicy{
    public void prepareBox(Box box) { box.recolor(BoxColor.YELLOW}; }
}
public class PolicyRegistry{
   public static NewBoxPolicy getNewBoxPolicyForDate(SomeDate date){
      switch (date.month()){
         case SomeMonth.JANUARY: return JANUARY_NEW_BOX_POLICY;
         case SomeMonth.FEBRUARY: return FEBRUARY_NEW_BOX_POLICY;
         default: throw new AssertionError();
      }
}