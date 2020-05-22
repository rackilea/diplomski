if (hi - lo) <= 6) {
    Comparable[] b = new Comparable[hi - lo + 1];
    //                                       ^^^^
    //                                We need plus one here.
    for (int i = 0; i < b.length; i++) {
        b[i] = a[lo + i];
    }
    Selection.sort(b);
    for (int i = 0; i < b.length; i++) {
        //               ^^^^
        //    We should either iterate to hi - lo + 1 or b.length.
        a[lo + i] = b[i];
    }
    return;
}