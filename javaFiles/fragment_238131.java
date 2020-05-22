for (int i = 0; i < Integer.MAX_VALUE; i++)
{
   long tmp = sum.longValue(); // Unboxing
   tmp += i;
   sum = Long.valueOf(tmp); // Boxing
}