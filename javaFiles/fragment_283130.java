for (int i = 0; i < DNA.length; i++) {
    switch (DNA[i]) {
    case 'A':
        DNA[i] = 'T';
        break;
    case 'T':
        DNA[i] = 'A';
        break;
    case 'C':
        DNA[i] = 'G';
        break;
    case 'G':
        DNA[i] = 'C';
        break;
    }
    revComp[i] = DNA[DNA.length - i - 1];
}