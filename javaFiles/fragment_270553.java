outerLoop:
for (int i = 0; i < n; i++) {
    // get the current matrix value
    t = A[[i]][j];
    // check if it has been already considered
    for (int z = 0; z < l; z++) {
        if (arrays[z].contains(t)) {
            continue outerLoop;
        }
    }
}