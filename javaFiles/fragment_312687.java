public DNA(String dna) {
    this.dna = dna;
    for (char c : dna.toCharArray()) {
        if (bases.indexOf(c) < 0) {
            numInvalid++;
        } else {
            numValid++;
        }
    }
}