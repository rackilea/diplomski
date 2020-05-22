public class AlphanumComparator implements Comparator
{
private Collator collator;
public AlphanumComparator(Collator collator) {
    this.collator = collator;
}
.....
    public int compare(Object o1, Object o2)
    {
......
result = thisChunk.compareTo(thatChunk); //should become
collator.compare(thisChuck, thatChuck);
....