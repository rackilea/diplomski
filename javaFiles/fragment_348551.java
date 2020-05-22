public class Test {//Start class name with capital case

     public static void main(String args[]){
          int counter = 1;
          while(counter <= 3) {//try until counter reaches 3
              boolean isSuccess = readFile(counter++);
              if(isSuccess) {
                  break;
              }
          }
     }

     private static boolean readFile(int attempt) {
          try {
             //read file here
             return true;          
           } catch(Exception e) {
             if(attempt == 3) {
                 e.printStackTrace();
             }
             return false;
          } 
     }
}