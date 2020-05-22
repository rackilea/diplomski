for (int i = DNA.length - 1; i >= 0; i--) {
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
    revComp[DNA.length - i - 1] = DNA[i];
}