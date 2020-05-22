public static void makeThemWait()
{
   foreach(F.Promise<WS.HttpResponse> x:newList)
   {
       F.Promise.waitAll(x);
   }
}