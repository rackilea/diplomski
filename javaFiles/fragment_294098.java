public static class LogDescComparator extends WritableComparator
{
    protected LogDescComparator() 
    {
        super(Text.class, true);
    }

    @Override
    public int compare(WritableComparable w1, WritableComparable w2)
    {

        Text t1 = (Text) w1;
        Text t2 = (Text) w2;
        String[] t1Items = t1.toString().split(" "); //probably it's a " "
        String[] t2Items = t2.toString().split(" ");
        String t1Value = t1Items[1];
        String t2Value = t2Items[1];
        int comp = t2Value.compareTo(t1Value); // We compare using "real" value part of our synthetic key in Descending order

        return comp;

    }
}