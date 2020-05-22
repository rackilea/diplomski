public void run() {
        long lastTime=System.nanoTime();
        final double amountOfTicks=60.0;
        double ns=1000000000/amountOfTicks;
        double delta=0; 

        int updates=0;
        int frames=0;
        long timer=System.currentTimeMillis();

        while (running) {
            long now=System.nanoTime();
            delta +=(now-lastTime) / ns;
            lastTime=now;
            if (delta>1) {      
                update();     <--- this is where your gravity() method belongs
                delta--;
                updates++;
            }
            render();     <---- this will be your repaint method
            frames++;
            if (System.currentTimeMillis()-timer>1000) {
                timer+=1000;
                currUpdates=updates;
                currFrames=frames;
                updates=0;
                frames=0;
            }
        }
    }