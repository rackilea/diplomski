Handler m_handler;
Runnable m_handlerTask ;  
m_handler = new Handler();   
m_handlerTask = new Runnable()
{
  @Override 
  public void run() { 

    // do something. call images() 
    m_handler.postDelayed(m_handlerTask, 1000);    

  }
  };
 m_handlerTask.run();