public class Unused {
   public String moveMe = "This is used only in other classes"
}

public class MyRealUssage {

  public static void main(String[] args) {
     System.out.println(new Unused().moveMe);
  }  
}