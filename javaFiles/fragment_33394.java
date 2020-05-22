for (int i = 1; i < 11; i++) {
    n = (int) (11 * Math.random());
    if (n > major) {
        major = n;
    }
    if (i==1) minor=n;
    else if (minor>n) minor=n;
    ...