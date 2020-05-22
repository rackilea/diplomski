public BasicRect horizontalCut(int c) {
    if(c > 0 && c < w){
        // make the cut
        x = x-w;
    }else{
        throw new IllegalArgumentException("Must be smaller than"
                + " width but larger than 0");
    }
    return this;
}