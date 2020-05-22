System.out.println("Enter word length");
if(in.hasNextInt()) {    
    n = in.nextInt();
 } else {
         while(in.hasNext()) //this is the loop i'm talking about
         {

             if(in.hasNextInt())
             {    
                 n = in.nextInt();
                 break;
             }
             else
             {
                 String c = in.next();
                 System.out.println("Please enter an integer");
             }
         }
     }