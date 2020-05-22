Color[] c = {Color.BLACK, Color.RED, Color.BLUE, Color.YELLOW, 
                 Color.GREEN, Color.CYAN, Color.MAGENTA, Color.PINK};
    for(int i=0; i<8; ++i){
        g.setColor(c[i]);
        g.fillArc(x, y, w, h, i*45, 45);
    }