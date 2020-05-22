public static double[] add(){
    double[] v = {1, 2, 3, 4, 5, 4};
    double[] w = {5, 4, 3, 3, 1};
    int a = v.length;
    int b = w.length;
    int capacity = Math.max(a,b);
    double[] s = new double[capacity];
    for (int i = 0; i<capacity; i++){
        s[i] = (i >= v.length ? 0 : v[i]) +  (i >= w.length ? 0 : w[i]);
    }


    return s;
}