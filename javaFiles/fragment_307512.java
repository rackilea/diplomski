for (A a : arrayList)
{
   if (a instanceof B)
   {
      B b = (B) a;
      b.methodSpecificToB();
   }
}