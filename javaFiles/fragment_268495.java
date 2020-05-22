public static String join(String x, String y){

   Set<Character> cx=new HashSet<Character>();
   Set<Character> cy=new HashSet<Character>();

   for (int k=0;k<x.length();k++)
       cx.add(x.charAt(k));

   for (int k=0;k<y.length();k++)
       cy.add(y.charAt(k));

   String result="";

   for (Character common: cx)
       if (cy.contains(common))
           result+=common;

   return result;
 }