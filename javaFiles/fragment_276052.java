BinaryOperator<int[]> merge = (t,u) -> {
    int[] result = new int[t.length + u.length];
    for (int i = 0, j = 0, k = 0; i < result.length; i++){
        if( j == t.length){
            result[i] = u[k++];
        } else if (k == u.length) {
            result[i] = t[j++];
        } else {
            result[i] = t[j] < u [k] ? t[j++] : u[k++];
        }
    }
    return result;
};