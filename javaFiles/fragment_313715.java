for (int i=0; i < x.length; i++){

    output[ i << 1     ] = new Float(x[i]);
    output[(i << 1) + 1] = new Float(y[i]);
    output[(i << 1) + 2] = "b0";
    output[(i << 1) + 3] = new Float(x[i] + value);
    output[(i << 1) + 4] = new Float(y[i] + value);
    output[(i << 1) + 5] = "b1";
}