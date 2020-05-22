buttongauche.setOnTouchListener(new View.OnTouchListener() {       

    public boolean onTouch(View v, MotionEvent event) {            
        switch (event.getAction()) {                               
        case MotionEvent.ACTION_DOWN:                              
            touching = true;                                       
            Thread volumeThread = new Thread() {                   
                public void run() {                                    
                    while (touching) {                             
                        audio.adjustStreamVolume(                  
                                AudioManager.STREAM_MUSIC,         
                                AudioManager.ADJUST_LOWER,         
                                AudioManager.FLAG_SHOW_UI);     
                        try {                                      
                            sleep(1000);                           
                        } catch (InterruptedException e) {         
                            e.printStackTrace();                   
                        }                                          
                    }                                              
                }                                                  
            };                                                     
            volumeThread.start();                                  
            break;                                                 
        case MotionEvent.ACTION_UP:                                
            touching = false;                                      
            break;                                                 
        }                                                          
        return false;                                              
    }                                                              
});