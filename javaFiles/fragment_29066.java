for (int k = 0; k < keys.length; k++) {

    // add a line break.
    if (k != 0)
        result.append(",");

    for(int l = 0; l < keys[k].length; l++){
        result.append(keys[k][l]);
        result.append(separator);
    }
}