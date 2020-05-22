for (int i=0; i < length; ++i) {
    for (int j=1; j < (length-i); ++j) {
        if (num[j-1] > num[j]){
            a = num[j-1];
            num[j-1] = num[j];
            num[j] = a;
        }
    }
}