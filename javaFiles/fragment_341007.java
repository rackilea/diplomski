public void count()
{
    int x;

    new Thread(new Runnable()
    {
        public void run()
        {
            while(x < 100)
            {
                x++;
                try
                {
                    Thread.sleep(1000);
                }catch(Exception e){}
            }
        }
     }).start();

     // do some more code...

     for(x = 0;x < 5;x++)
         for(int y = 0;y < 10;y++)
             System.out.println(myArrayElement[x][y]);
 }