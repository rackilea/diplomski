private volatile int timer = 0;

public synchronized void tick(){
    if(updateVar == true) timer++;
}

pubic synchronized int getTimer(){
    return timer;
}