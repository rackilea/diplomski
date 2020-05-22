private void Scan()
{
     while(scanning)
     {
         var entered = stopwatch.ElapsedMilliseconds;
         scan(); 
         scand.WaitOne();
         var duration = stopwatch.ElapsedMilliseconds - entered;
         var delay = Math.Max(0, 500 - duration);
         Thread.Sleep(delay);
     }
}