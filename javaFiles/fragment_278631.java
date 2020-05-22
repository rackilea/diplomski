public void run() 
    {
            if (Looper.myLooper() == null)
            {
              Looper.prepare();
            }
            thisHandler = new Handler();

         ....
    }