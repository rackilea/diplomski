static String kangaroo(int k1, int v1, int k2, int v2) {
    float x = (k2 - k1)/(v1 - v2);
    if(x == (int) x) { //check if the intersection point is an integer
        return "YES";
    }
    return "NO";
}