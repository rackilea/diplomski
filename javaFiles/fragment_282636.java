int framesPerSecond=60;
double frameTime=1000.0/framesPerSecond; 

while(running){
    for(Updatable updatable:updatables){
         //should actually measure the frame time since it would actually be 
         //exactly this. System.nanoTime() can be used for this
         updatable.update(frameTime); 

         //depending on your graphics library each updatable object may be given
         //the opportunity to render itself here

    }

    renderFrame(); //render frame as appropriate for your graphics library
    Thread.sleep(frameTime); 
}