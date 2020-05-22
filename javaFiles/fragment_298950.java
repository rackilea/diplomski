List<float[]> list=new ArrayList<float[]>();
list.add(new float[] {0.0f});
list.add(new float[] {1.0f});

float[] key = new float[2];

Comparator<float[]> c = new Comparator<float[]>() {
    public int compare(float[] f1, float[] f2) { 
        return f1.length - f2.length;
    }
};