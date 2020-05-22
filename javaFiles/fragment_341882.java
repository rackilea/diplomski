for (j = 1; j <= u.length; j++) {
    for (i = 1; i <= v.length; i++) {
        if (u[i - 1] == v[j - 1]) {
            tracker = 0;
        } else {
            tracker = 1;
        }