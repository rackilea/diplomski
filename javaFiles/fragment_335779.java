private final Executor executor = Executors.newSingleThreadExecutor();

public void writePacket(final String packet) 
{
  // schedules execution on the single thread of the executor (so only one background operation can happen at once)
  //
  executor.execute(new SwingWorker<String, Void>()
      {

        @Override
        protected String doInBackground() throws Exception
        {
          // called on a background thread


          /* This method writes the packet to the port - established earlier */
          System.out.println("writing out this packet->"+packet+"<-");
          System.out.println(packet);
          String thePacket = readPacket();  //where the port listener is invoked.  
          return thePacket;            
        }

        @Override
        protected void done()
        {
          // called on the Swing event dispatch thread


          try
          {
            final String thePacket = get();

            // update GUI with 'thePacket'
          }
          catch (final InterruptedException e)
          {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          catch (final ExecutionException e)
          {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } 
        }
      });
}

private String readPacket() 
{
  String thePacket ="";
  String fromServer="";
  //Below is the loop that freezes everything.   
  try 
  {
    while ((fromServer = in.readLine()) != null) 
    { 
      if (thePacket.equals("")) 
        thePacket = fromServer;
      else 
        thePacket = thePacket+newLine+fromServer;
    }
    return thePacket;  //when this happens, all listening should stop.   
  } 
  catch (IOException e) 
  {
    e.printStackTrace();
    return null;
  }
}