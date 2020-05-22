else if(lastButtonPressed == Shape){
         shape = new Rectangle2D.Double(x, y, w, w);
         echo("Square",x,y);
         r = p.nextInt(255);
         g = p.nextInt(255);
         b = p.nextInt(255);
         color = new Color(r, g, b);
    }