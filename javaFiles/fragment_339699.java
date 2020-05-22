public class Duplicate {
   public static void main(String[] args) {
   Scanner keyboard = new Scanner(System.in);
   System.out.print("Enter a filename: ");
   String fileName = keyboard.nextLine();
   if (fileName.equals("")) {
      System.out.print("Error: User did not specify a file name.");
   } 
   else {
     Scanner inputStream = null;
    try {
        inputStream = new Scanner(new File(fileName));
    } 
    catch (FileNotFoundException e) {
       System.out.println("File couldn't be found");
       System.exit(0);
    }

   String[] address = new String[100];
   int i = 0;
       while (inputStream.hasNextLine()) {
           String email = inputStream.nextLine();
           // System.out.println(email);
            address[i] = email.replace(" ", "")+" ";// add a space at the end of the line

          char ch1,ch2; //Variables to compare charachters
          String result ="";//Variable to store the final result
           for(int j=0; j<address[i].length()-1; j++){
               ch1=address[i].charAt(j); // get the first character
               ch2=address[i].charAt(j+1); // get the next character 
              if(ch1!=ch2) {// compare first and second, second and third ..., and so on; if not equal add to result            
              result = result + ch1;
              }
            }
          char [] res = result.toCharArray();
          System.out.println(Arrays.toString(res)); // Printing the result
          i++;
      }
    }
  }  
}