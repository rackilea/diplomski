int log(int b, int n ) {
    if (n <= b) {
        return 1;
    } else {
        return log(b, n/b)+1 ;

    }
}