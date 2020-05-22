public static float[] floatMe(short[] pcms) {
    float[] floaters = new float[pcms.length];
    for (int i = 0; i < pcms.length; i++) {
        floaters[i] = pcms[i];
    }
    return floaters;
}