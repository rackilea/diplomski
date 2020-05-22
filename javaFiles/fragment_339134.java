public static void main(String [ ] args) {
         try{
             System.out.println("1"); //<--When your code runs it first print 1
             method();  //<--Then it will call your method here
         }
         catch(IOException e) { //<---Won't catch anything because you caught it already
             System.out.println("4");
         }
    }

public static void method() throws IOException { //<--Your Signature contains a trows IOException (it could trhow it or not)
     try {
         System.out.println("2");  //<--It will print 2 and thows an IOException
         throw new IOException(); //<--now it trows it but as you're using a try catch it will catch it in this method
     }
     catch(IOException e) {//it caught the exception in spite or trhow it so it will print 3
         System.out.println("3"); //<--Prints 3
     }
 }