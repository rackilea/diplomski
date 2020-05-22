private long time = System.currentTimeMillis();

//...

// draw call:
if(lastFrame != null && System.currentTimeMillis() - time >= 1000){
    // do stuff
    time = System.currentTimeMillis();
}