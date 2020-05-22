static class MedalsOfCountry implements Comparable<MedalsOfCountry> {
    int goldCount;
    int silverCount;
    int bronzeCount;

    MedalsOfCountry(int count) {
        goldCount += count;
    }

    @Override
    public int compareTo(MedalsOfCountry medals) {
        int compareGold = this.goldCount - medals.goldCount;
        if (compareGold != 0) {
            return compareGold;
        }
        int compareSilver = this.silverCount - medals.silverCount;
        if (compareSilver != 0) {
            return compareSilver;
        }
        return this.bronzeCount - medals.bronzeCount;
    }
}