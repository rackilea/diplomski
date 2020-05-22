public class RemoveDuplicates {
      public static void main(String[] args) {
           System.out.println(new RemoveDuplicates().result("hellllo", false)); //helo
           System.out.println(new RemoveDuplicates().result("hellllo", true)); //hello
      }

      public String result(String input, boolean doubleLetter){
           String pattern = null;
           if(doubleLetter) pattern = "(.)(?=\\1{2})";
           else pattern = "(.)(?=\\1)";
       return input.replaceAll(pattern, "");
      }
 }

 (.)    --> matches any character and puts in group 1. 
 ?=     --> this is called a positive lookahead. 
 ?=\\1  --> positive lookahead for the first group