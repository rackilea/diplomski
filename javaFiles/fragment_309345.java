public void updateSeries(int point, int decay)
    {

        g.setColor(Color.blue);
        int nx = series[point][0];

        series[point][0] -= decay;
        if ( point-1 >= 0 ) {
            series[point-1][0] -= decay;
        }

        int ny = series[point][1];
    //    prevx -= decay;

    //    g.drawLine(prevx-decay, prevy, nx-decay, ny );         
    g.drawLine(prevx, prevy, nx-decay, ny );     
        prevx = nx-decay;
        prevy = ny;
    }