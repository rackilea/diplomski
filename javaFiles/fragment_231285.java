if(Greenfoot.isKeyDown("w") ){
        setLocation(getX(), getY()-speed);
    }
    else if(Greenfoot.isKeyDown("a")){
        move(-speed);
    }
    else if(Greenfoot.isKeyDown("s")){
        setLocation(getX(), getY()+speed);
    }
    else if(Greenfoot.isKeyDown("d")){
        move(+speed);
    }
    else if(runDuration < baseRunDuration){
         runDuration++;
    }