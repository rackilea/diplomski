public class MyFuture<?> extends Future<?> 
{
      Boolean myVar;
      Future<?> fut;
      MyFuture<?>(Future<?> fut)
      {
           this.fut = fut;
      }

      public void setVar(Boolean v) 
      {
          ...
      }
}