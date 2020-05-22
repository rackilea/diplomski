public void fullWriteNames() {
    char first = lastname.charAt(0);

    if (first >= 'A' && first <= 'K') 
        writeNamesA2K();
    else if (first >= 'L' && first <= 'R')
        writeNamesL2R();
    else if (first >= 'S' && first <= 'Z')
        writeNamesS2Z();
}