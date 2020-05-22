public class ExtraConfiguration
    implements Comparable<Object>
{
    public int themeChanged;

    public int compareTo(Object that)
    {
        if (!(that instanceof ExtraConfiguration)) {
            throw new ClassCastException();
        } else {
            return compareTo((ExtraConfiguration) that);
        }
    }

    public int compareTo(ExtraConfiguration that)
    {
        return this.themeChanged - that.themeChanged;
    }
}