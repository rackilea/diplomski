unsigned ix = get_global_id (0)%w2;
     unsigned iy = get_global_id (0)/w2;

        if (ix >= w2) return;
        if (iy >= h2) return;

        double r = ix * 0.001;
        double i = iy * 0.001;

        double x = 0;
        double y = 0;

        double magnitudeSquared = 0;
        int iteration = 0;

        while (magnitudeSquared < 4 && iteration < 255) 
        {
            double x2 = x*x;
            double y2 = y*y;
            y = 2 * x * y + i;
            x = x2 - y2 + r;
            magnitudeSquared = x2+y2;
            iteration++;
        }

        b[(iy * w2 + ix)]   =(uchar4)(iteration/5.0,iteration/5.0,iteration/5.0,244);