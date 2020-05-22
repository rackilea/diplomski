Producer()
{
   if (buffer.hasemptyspaces())
   {
      produce(buffer);
   }
   else
   {
      sleep(n);
   }
}

Consumer()
{
   if (buffer.hasfullspaces())
   {
      consume(buffer);
   }
   else
   {
      sleep(n);
   }
}