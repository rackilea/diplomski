if (Mouse.isButtonDown(0)){
        Mouse.setGrabbed( !Mouse.isGrabbed() );
    } 
   if(Mouse.isGrabbed()){
       camera.processMouse(1, 80, -80);
   }