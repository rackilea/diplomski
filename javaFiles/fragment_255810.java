public double [] getArray(){
    double[] array = new double[values.size()];
    for(int i =0;i<values.size();i++)
    {
        array[i] = values.get(i) != null ?values.get(i):  0.0;
    }
    return array;
}