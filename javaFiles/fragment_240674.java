public static Color doubleToColor(double x,double maxx){
        float cR=(float)(0.5 + (x / (2 * maxx)));
        float cG=(float)(0.5 + (x / (2 * maxx)));
        float cB=(float)(0.5 - (x / (2 * maxx)));
        Color c = new Color(cR,cG,cB);
        return c;
    }