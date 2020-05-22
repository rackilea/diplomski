public static String txt (String a) 
   {

      String s="";  
String text="";     
 int i=0;
      try{
         Scanner scan =new Scanner(new File(a));

         while(scan.hasNext()){

            s =scan.next(); // läser en rad från fil till s
          text=text+s;
            i++;
           // System.out.print(s + " "); // skriver ut den 

         }

      }
      catch( Exception exp) {}

      return text;
      }