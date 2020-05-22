class StaticVariable
{
   static int counter=0;
   public void increment()
   {
       counter++;
   }
   public static void main(String args[])
   {
       StaticVariable objectA = new StaticVariable();
       StaticVariable objectB = new StaticVariable();
       objectA .increment();
       objectB .increment();
       System.out.println("objectA- counter is: "+ objectA.count);
       System.out.println("objectB- counter is: "+ objectA.count);
   }
}