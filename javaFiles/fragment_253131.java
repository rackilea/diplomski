static class KNNEntry implements Comparable<KNNEntry> {
    final Text text;
    final Double dist;

    KNNEntry(Text text, Double dist) {
        this.text = text;
        this.dist = dist;
    }

    @Override
    public int compareTo(KNNEntry other) {
        int comp = this.dist.compareTo(other.dist);
        if(0 == comp)
            return this.text.compareTo(other.text);
        return comp;
    }
}