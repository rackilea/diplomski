lastRender = System.nanoTime(); //change it to nano instead milli
draw.render();
draw.fps++;

if (FPS_CAP > 0) {
    while ( now - lastRender < (1000000000 / FPS_CAP))
    {
        Thread.yield();

        //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
        //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
        //FYI on some OS's this can cause pretty bad stuttering. 
        try {Thread.sleep(1);} catch(Exception e) {}

        now = System.nanoTime();
    }
}