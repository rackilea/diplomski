for (int i = y-r; i < y+r; i++) {
    for (int j = x; (j-x)^2 + (i-y)^2 <= r^2; j--) {
        //in the circle
    }
    for (int j = x+1; (j-x)*(j-x) + (i-y)*(i-y) <= r*r; j++) {
        //in the circle
    }
}