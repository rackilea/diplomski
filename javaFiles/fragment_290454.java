private ShutDownHandler mRedrawHandler = new ShutDownHandler(); 

     class ShutDownHandler extends Handler {  
            @Override  
            public void handleMessage(Message msg) {  
         client.getConnectionManager().shutdown();
            }  

            public void doJob(long delayMillis) {  
              this.removeMessages(0);  
              sendMessageDelayed(obtainMessage(0), delayMillis);  
            }  
          };