int midX = 500;
    int midY = 340;
    int radius[] = {118,40,90,40};
    int nPoints = 16;
    int[] X = new int[nPoints];
    int[] Y = new int[nPoints];

    for (double current=0.0; current<nPoints; current++)
    {
        int i = (int) current;
        double x = Math.cos(current*((2*Math.PI)/max))*radius[i % 4];
        double y = Math.sin(current*((2*Math.PI)/max))*radius[i % 4];

        X[i] = (int) x+midX;
        Y[i] = (int) y+midY;
    }

    g.setColor(Color.WHITE);
    g.fillPolygon(X, Y, nPoints);