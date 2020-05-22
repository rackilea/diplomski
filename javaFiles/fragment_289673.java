public class Unused {

}

public class MyRealUssage {
  public String moveMe = "This is used only in other classes";    
  public static void main(String[] args) {
     System.out.println(new MyRealUssage().moveMe);
  }  
}