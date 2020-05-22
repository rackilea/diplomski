public static void main(String [ ] args) {
         try{
             System.out.println("1"); //<--When your code runs it first print 1
             method();  //<--Then it will call your method here
         }
         catch(IOException e) { //<---It will catch the Exception and print 4
             System.out.println("4");
         }
    }

public static void method() throws IOException { //<--Your Signature contains a trows IOException (it could trhow it or not)
         System.out.println("2");  //<--It will print 2 and thows an IOException
         throw new IOException(); 
 }