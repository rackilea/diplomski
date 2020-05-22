package yourXYZpackage;

public class yourABCclass{

//Declare in class body so your methods(functions) can access 
//and the changes made will be global in C++ context.  
  static int count=0; 

  void counter()
  {
        count = count++;
        System.out.println(count); 
        //thats how you can display on console
  }
  //this is the main method like C++
  public static void main(String[] args){
      
      for(int i=0;i<5;i++)
      {
          counter();
      }
  }
}