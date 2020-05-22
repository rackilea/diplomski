Runnable r = new Runnable(){

    @Override
    run(){
        for(int i = 0; i < image.getHeight(); i++){
            // wait 100ms to 'slow down'
            Thread.sleep(100)// surround with try/catch, it may throw an exception
            line = line + 1; //increase amount of visible lines
            repaint(); //update the panel
        }
    }
}

//i don't know when you want to start the animation
new Thead(r).start(); //so trigger at free will