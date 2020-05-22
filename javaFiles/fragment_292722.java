Color getColor(int width, int height, int a, int b){
    double d1 = ((double) height / width) * a;
    double d2 = ((double) -height / width) * a + height;

    if(d1 > b && d2 > b) return greenColor;
    if(d1 > b && d2 < b) return blueColor;
    if(d1 < b && d2 > b) return redColor;
    return whiteColor;
}