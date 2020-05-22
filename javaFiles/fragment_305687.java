class DPolygon
{
    private double[] z;
    //Your other attributes here..
    //Your constructors here..

    public double getSumOfZ(){
        double sum = 0.0;
        if(z != null && z.length > 0)
            for(int i=0; i<z.length; i++)
                sum += z[i];
        return sum; 
    }
}