// GamePanel.java#run():
    for (Bullet bullet:Bullet.bullet) { //your code is iterating over Bullet.bullet here
        bullet.move(); //you call Bullet#move here
    }

// Bullet.java#move():
    public void move(){
        if(y< -height){
           bullet.remove(this); //this will remove the current bullet from Bullet.bullet
           // ultimately causing the ConcurrrentModificationException in GamePanel.run()
        }
        y-=5;
    }