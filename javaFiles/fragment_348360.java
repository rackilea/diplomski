try {

     .....

     if(guesses >= 1) {
        background = Toolkit.getDefaultToolkit().createImage("drac1.jpg");
        // old code - g.drawImage(background, 0, 0, null);
        while(!g.drawImage(background, 0, 0, null)) Thread.sleep(100); // - new code
     }

     if(guesses >= 2) {
        background = Toolkit.getDefaultToolkit().createImage("drac2.jpg");
        // old code - g.drawImage(background, 0, 0, null);
        while(!g.drawImage(background, 0, 0, null)) Thread.sleep(100); // - new code
     }

     .....

    } catch(InterruptedException ex) {
       ex.printStackTrace();
    }