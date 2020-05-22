class Tryit {   
      public static void main(String args[])   
        throws java.io.IOException { 

        char ch, answer; 
        Scanner scanner = new Scanner(System.in); 
         while(true) {
        System.out.println("Please Enter a Secret Character for another user to guess."); 
        answer = scanner.next().charAt(0);

        System.out.println("There is a Secret character for you...Can you guess it: \n"); 
        ch = scanner.next().charAt(0); 

           if(ch == answer)    
           {   
            System.out.println("** Right **"); 
           }
           else 
          {
          System.out.println("** Try Again **"); 
          } 
        }
      }   
    }