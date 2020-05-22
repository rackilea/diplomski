Class c = getClass();
Field f = null;
while (f == null && c != null) // stop when we got field or reached top of class hierarchy
{
   try
   {
     f = c.getDeclaredField("privateField");
   }
   catch (NoSuchFieldException e)
   {
     // only get super-class when we couldn't find field
     c = c.getSuperclass();
   }
}
if (f == null) // walked to the top of class hierarchy without finding field
{
   System.out.println("No such field found!");
}
else
{
   f.setAccessible(true);
   System.out.println(f.get(this));
}