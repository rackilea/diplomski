for (int i = 0; i <= x.length; i++) {// "<=" is not mistake, 
                                     // in last iteration we print all elements 
                                     // from second array
    boolean exist = false;
    for (int j = 0; j < y.length; j++) {
        if (i < x.length) {
            if (x[i] == y[j])
                exist = true;
        } else
            System.out.println(y[j]);
    }
    if (!exist && i < x.length)
        System.out.println(x[i]);
}