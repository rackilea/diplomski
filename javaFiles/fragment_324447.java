public static float[] flatten(List<List<float[]>> lists) {
    // get the total size.
    int size = 0;
    for (List<float[]> list : lists) 
        for (float[] floats : list) 
            size += floats.length;
    // create an array of the right size.
    float[] ret = new float[size];
    int i = 0;
    for (List<float[]> list : lists)
        for (float[] floats : list) {
            // bulk copy the array
            System.arraycopy(floats, 0, ret, i, floats.length);
            i += floats.length;
        }
    return ret;
}