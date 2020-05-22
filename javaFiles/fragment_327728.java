Log("first");
     // ...
     using (new IndentedLog())
     {
         Log("second");
         // ...
         using (new IndentedLog()) 
         {
            Log("third");
         }
     }