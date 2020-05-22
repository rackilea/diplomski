public class Testing {

   public static void main(String args[]) throws Exception {
       Scanner input = new Scanner(System.in);
        System.out.println("Select word from list:");
        System.out.println();

        String searchAgain = "";
        while(!"No".equalsIgnoreCase(searchAgain )){
           System.out.println("Do you want search for other word?");
           System.out.println("Enter: Yes or No");
           searchAgain = input.next();
           if ("Yes".equalsIgnoreCase(searchAgain)) {
              System.out.println("Write your word: ");
              String textToSearch = input.next();
              searchWord(textToSearch );
           } else if ("No".equalsIgnoreCase(searchAgain)) {
                 System.out.println("Program closed.");
           } else{
                 System.out.println("Invalid Input.");
           }
        }
     }

     private void searchWord(String textToSearch ){
        //your logic here which performs the search and prints the result
     }
 }