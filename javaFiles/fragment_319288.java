//main gameLoop
public void gameLoop(){
    long startTime = System.currentTimeMillis();
    long cumTime = startTime;

    while(running){
        long timePassed = System.currentTimeMillis() - cumTime;
        cumTime += timePassed;

        update(timePassed);

        Graphics2D g = s.getGraphics();
        draw(g);
        g.dispose();
        s.update();

        try{
            Thread.sleep(20);
        }catch(Exception ex){}
    }
} //<-here is one you've lost

//update animation
public void update(long timePassed){
}

//draw to screen
public abstract void draw(Graphics2D g);