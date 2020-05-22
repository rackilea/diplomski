else if (b[0] < c[0]) {
    result = merge(new int[]{b[0]},merge(Arrays.copyOfRange(b,1,b.length),c));
    return result;
} else if (b[0] > c[0]) {
    result = merge(new int[]{c[0]},merge(b,Arrays.copyOfRange(c,1,c.length)));
    return result;
} else {