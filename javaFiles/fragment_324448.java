public static float[] flatten(List<List<float[]>> lists) {
    int size = 0;
    for (int i = 0; i < lists.size(); i++) {
        List<float[]> list = lists.get(i);
        for (int j = 0; j < list.size(); j++) {
            float[] floats = list.get(j);
            size += floats.length;
        }
    }
    float[] ret = new float[size];
    int pos = 0;
    for (int i = 0; i < lists.size(); i++) {
        List<float[]> list = lists.get(i);
        for (int j = 0; j < list.size(); j++) {
            float[] floats = list.get(j);
            System.arraycopy(floats, 0, ret, pos, floats.length);
            pos += floats.length;
        }
    }
    return ret;
}