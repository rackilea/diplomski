public float[][] elemen_wise_function(float[][] x,
                                      Function<Float, Float> f) {

    float[][] Constructed_array = new float[x.length][x[0].length];
    for (int i=0; i<x.length; i++) {
        for (int j = 0; j < x[0].length; j++) {
            Constructed_array[i][j] = f.apply(x[i][j]);
        }
    }
    return Constructed_array;
}