public class Factory {
  public static <T> T getImplementation(){
    if(<SDK_LEVEL_INCOMPATIBLE>){
      return (T)new <package>.OldSchoolAnimator();
    }else{
      return (T)new <package>.SuperAnimator();
    }
  }
}


...
SomeImplementation impl = new Factory().getImplementation();
...