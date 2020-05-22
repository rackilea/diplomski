Comparator<float[]> byFirstElement = new Comparator<float[]>() {
    @Override
    public int compare(float[] arg0, float[] arg1) {
        return Float.compare(arg0[0], arg1[0]);
    }
};
Collections.sort(theArray, byFirstElement);