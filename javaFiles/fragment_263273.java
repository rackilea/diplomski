// Sort by Receipt Number in 'Ascending Order'.
@Override
public int compareTo(Pengiriman comparePengiriman) {
    int compareNoResi = comparePengiriman.getNoResi();

    //ascending order
    return this.no_resi - compareNoResi;

    // If you want Descending order then use this instead:
    // return compareNoResi - this.no_resi;
}