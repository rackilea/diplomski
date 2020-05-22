public BasicRect horizontalCut(int c) {
    BasicRect br = new BasicRect();
    br.x = x;
    br.y = y;
    br.h = h;
    br.w = w;
    if(c > 0 && c < w){
        // make the cut
        br.x = x-w;
    }else{
        throw new IllegalArgumentException("Must be smaller than"
                + " width but larger than 0");
    }
    return br;
}