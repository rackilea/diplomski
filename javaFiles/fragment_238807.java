public Pizza(int x, int y) {
        super(x,y);
       //P is null here - add P=new Poligon()
        P.xpoints = new int[]{x, x+100, x+200};
        P.ypoints = new int[]{y, y+100, y};
        P.npoints = 3;
    }