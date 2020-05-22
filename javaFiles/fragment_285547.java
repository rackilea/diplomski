try(Object<AutoCloseable> smth = source.get())
{
   try {
       // operate on smth
   } catch (Exception e)
   {
      smth.rollback();
   }
}