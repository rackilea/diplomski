public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int correctAnswers = 0;
    /*This a is called a Do-While loop and will execute the code inside once         
    *before checking the boolean statement
    */
    do{ 
        System.out.println("What is your name?"); //Line A
        String name = scan.nextLine();
        System.out.println("Entered name: " + name + "\n");
        //Removed printing empty line and replaced with new line character

        switch (name){
            case "Sam":
                 System.out.println("aaa");
               correctAnswers++;
                  break;      // From here it repeats back to line A
              case "Michael":
                  System.out.println("bbb!");
                  correctAnswers++;
                  break;      // From here it repeats back to line A        
              case "Arnold":
                  System.out.println("ccc!");
                  correctAnswers++;
                  break;      // From here it repeats back to line A   
              default:
                  System.out.println("Try again!");
         }
    } while (correctAnswers < 3);
    System.out.println("Thank you");
  }
}