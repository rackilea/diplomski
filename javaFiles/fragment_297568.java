Handler m_handler;
   Runnable m_handlerTask ;  
   m_handler = new Handler();
   m_handlerTask = new Runnable()
   {
     @Override 
     public void run() {

    // do something 
    m_handler.postDelayed(m_handlerTask, 1000); // instad of 1000 mention the delay in milliseconds
     }
   };
   m_handlerTask.run();