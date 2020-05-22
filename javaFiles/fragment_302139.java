public static double getIntegralFromArray(double[] ar, double xDist)
    {
        double base = 0;
        double prev = 0;
        double triHeight = 0;
        double rectHeight = 0;
        double tri = 0;
        double rect = 0;
        double integral = 0;
        for (int i = 0; i < ar.length; i++) {
            triHeight=Math.abs(ar[i]-prev); // get Height Triangle
            tri = xDist*triHeight/2;    // get Area Triangle
            if(ar[i]<=prev){
                rectHeight = Math.abs(base-ar[i]); // get Height Rectangle
            }else {
                rectHeight = Math.abs(base-(ar[i]-triHeight)); // get Height Rectangle
            }
            rect = xDist*rectHeight;    // get Area Rectangle
            integral += (rect + tri); // add Whole Area to Integral
            prev=ar[i];
        }
        return integral;
    }

    double[] ar = new double[]{1,2,3,2,2,3,1,3,0,3,3};
    System.out.println(MyMath.getIntegralFromArray(ar, 1));

    Area under 'curve': 21.5