/**
 * Compares Objects by human values instead of traditional machine values.
 * 
 * @modified Tristan Everitt
 */
public class AlphaNumericObjectComparator<T> implements Comparator<T>
{

    private AlphaNumericStringComparator stringComparator;

    public AlphaNumericObjectComparator()
    {
        this(Locale.getDefault());
    }

    public AlphaNumericObjectComparator(Locale locale)
    {
        this.stringComparator = new AlphaNumericStringComparator(locale);
    }

    @Override
    public int compare(T t1, T t2)
    {
        return compareStrings(t1.toString(), t2.toString());
    }

    protected int compareStrings(String s1, String s2)
    {
        return stringComparator.compare(s1, s2);
    }
}