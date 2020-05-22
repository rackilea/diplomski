public static Object[] join(Object[] obj1, Object[] obj2) {
    Object[] sum = new Object[obj1.length + obj2.length];
    int len = Math.max(obj1.length, obj2.length);
    for (int i = 0; i < len; i++) {
        if (i < obj1.length) {
            sum[i] = obj1[i];
        }
        if (i < obj2.length) {
            sum[i + obj1.length] = obj2[i];
        }
    }
    return sum;
}