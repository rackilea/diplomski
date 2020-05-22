Point[] shortDist = new Point[Y.length];

    int n = 0;
    for (int i = 0; i <Y.length; i++)
        {
            int A = Y[i].getX();
            if ((V-A)*(V-A) <= distance)
                {
                    shortDist[n] = Y[i];
                }
        }