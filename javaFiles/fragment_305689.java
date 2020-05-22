class DPolygon
{
    //Your other attributes here..
    private double[] x,y,z;
    public DPolygon(){
        initCoordinates();    //Init all arrays in the constructor 
    }

    //Initialize all x,y,z arrays.
    private void initCoordinates(){
        x = new double[]{0.0, 0.0, 0.0, 0.0};
        y = new double[]{0.0, 0.0, 0.0, 0.0};
        z = new double[]{0.0, 0.0, 0.0, 0.0};
    }
}