for (int ligne = 0; ligne < 9; ligne++) {
    for (int colonne = 0; colonne < 9; colonne++) {
        BitSet bitSet = new BitSet();
        bitSet.set(1, 10);
        solveur[ligne][colonne] = bitSet;
    }
}