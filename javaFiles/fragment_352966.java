public static void addScore(int prompt, String stats) //Calls the WriteAfterNthLine method with a prompt number and stats string.
 {
   String /*Object ...??*/ tmp = null;
   try {
     switch(prompt) { 
       case 1:
         tmp = findTextInFile("NORMAL");
         break;
       case 2:
         tmp = findTextInFile("SMALL");
         break;
       case 3:
         tmp = findTextInFile("NUMBERS");
         break;
       case 4:
         tmp = findTextInFile("COMMON WORDS");
         break;
       case 5:
         tmp = findTextInFile("OTHER");
         break;
       default:
         System.out.println("ERROR INVALID SUBMISSION"); 
         break;
     }// end-switch
   } catch(Exception e) {// end-try
     System.out.println(e);
   }
   if(tmp != null) {
     writeAfterNthLine("data.txt", stats, tmp); // ;)
   }
 }//end-addScore