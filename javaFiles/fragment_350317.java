static private String generateValidPassword() 
{ 
    String numcase = "";
    String lowcase = "";
    String upcase = "";
    String halfpass = "";
    String returnString = "";

    System.out.print(returnString);

    Random r = new Random();

    String loweralphabet = "abcdefghijklmnopqrstuvwxyz";
   int n = loweralphabet.length();

   String upperalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   int N = upperalphabet.length();

   int num = 0;
   for(int i=0;i<3;i++)
   {
       num=r.nextInt(9);

       numcase = String.valueOf(num);
       returnString += numcase;
   }
   for(int i=0;i<3;i++)
   {
       lowcase = String.valueOf(loweralphabet.charAt(r.nextInt(n)));
       returnString += lowcase;
   }
   for(int i=0;i<3;i++)
   {
       upcase = String.valueOf(upperalphabet.charAt(r.nextInt(N)));
       returnString += upcase;
   }
   return returnString;
 }