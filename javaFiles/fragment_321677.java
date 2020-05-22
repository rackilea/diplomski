@Override
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    System.out.println("Beginning of paintComponent");

    System.out.println("Completed making the Graphics objects");
    //yIntercept needs to be reinitialized when the repaint(); is called again
    if(yInterceptLocation == 1080){
        yInterceptLocation = 0;
    }

    for(int i = 0;i<(x*y)/64;i++){
            if(xInterceptLocation == 0){//If i == 0 then it wont add 8 first (thus preventing a gap)
            g.fillRect(xInterceptLocation, yInterceptLocation, 8, 8);
            xInterceptLocation += 8;
        }else{//Any other time we want to add 8 to space out the squares
            Color newColor = changingColors();
            g.setColor(newColor);
            g.fillRect(xInterceptLocation, yInterceptLocation, 8, 8);
            xInterceptLocation += 8;
            if(xInterceptLocation == 1920){//if xInterceptLocation = 1920 then it adds 8 to yIntercept and sets x to 0 (creating a new line)
                xInterceptLocation = 0;
                yInterceptLocation += 8;
            }
        }
    }
}