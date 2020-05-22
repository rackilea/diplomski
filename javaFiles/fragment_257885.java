if(IsMoving() && X.equals(dests)) {
    for(int i = dests.length - 1; i > 0; i--) {
        if(X[i] != X[i-1])
            dests[i] = X[i-1];
    }

    if(left) {
        dests[0] = X[0] - 10;
    } else if(right) {
        dests[0] = X[0] + 10;
    }
}