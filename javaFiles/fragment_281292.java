public int compareTo(Sample sampleToCompare) {
    if (flag == 1) {
        return this.c.compareTo(sampleToCompare.c);
    }
    if (flag == 0) {
        // current stuff
    }
    ...
}