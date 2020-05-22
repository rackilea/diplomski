private static volatile boolean out = false;

  public static void main( String[] args )
  {
    new Thread( new Runnable()
    {
      @Override
      public void run()
      {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        try
        {
          reader.readLine();
          // will only be executed after input since BufferedReader.readLine() is blocking.
          out = true;
          reader.close();
        }
        catch ( Exception e )
        {
          e.printStackTrace();
        }
        System.out.println( " have received the keyboard" );
      }
    } ).start();

    new Thread( new Runnable()
    {
      @Override
      public void run()
      {
        // added to show that the 2nd thread started.
        System.out.println( "Thread 2 started running...." );

        while ( true )
          if ( out )
            break;
        System.out.println( " exit the loop" );
      }
    } ).start();
  }