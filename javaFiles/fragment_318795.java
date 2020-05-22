// Bullet.java#move():
    public boolean move(){
        if(y< -height){
           return true; // instruct GamePanel.run() to remove this bullet
        }
        y-=5;
        return false; // keep this bullet
    }

// GamePanel.java#run():
    Iterator<Bullet> it = Bullet.bullet.iterator();
    while (it.hasNext()) {
        Bullet bullet = it.next();
        if (bullet.move()) { // if bullet should be removed
            it.remove(); // remove it from the list
        }
    }