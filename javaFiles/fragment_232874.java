public void doStuff(Object[] lists) 
{ 
   Object entry0 = lists[0]; //Object Array only contains objects.
   char[] charArr = (char[]) entry0; // Explicit cast: You know that lists[0] is a char Array!
   for (char c : charArr)
   {
     System.out.println("Char Array contains: " + c);
   }
}