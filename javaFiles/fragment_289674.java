public class MyRealUssage {
  public String moveMe = "This is now used only this class";    
  public static void main(String[] args) {
     System.out.println(getMoveMe());
  }  
  public String getMoveMe() {
     return moveMe;
  }
}