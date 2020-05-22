public static int factor(int m) {   
    for(int y=2 ; y <= m/2 ; y++) {
        if(m%y==0) {
            return y;
            continue;
        }
    }
    return y;
}