private long time = System.currentTimeMillis();

//...

// draw call:
long delta = System.currentTimeMillis() - time;
if(lastFrame != null && delta >= 1000){
    int framesMissed = delta / 1000; // rounds to full seconds
    for(int i=0;i<framesMissed;i++){
        // do stuff for each missed frame/picture
    }
    // apply "overlap" so we actually carry the right result to the next call
    time = System.currentTimeMillis() - (delta-(1000*framesMissed));
}