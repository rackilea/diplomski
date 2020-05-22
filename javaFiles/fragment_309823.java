/**
 * @param <T> item type
 * @param <C> context object type
 */
public interface EnumTableFormatItem<T, C> {
    Object getValue(C context, T item);
    String getLabel();
}

/**
 * @param <T> item type
 * @param <C> context object type
 * @param <E> enum type which specifies each column
 */
static public class EnumTableFormat
    <
       T, C, 
       E extends Enum<E> 
                & EnumTableFormatItem<T, C>
    > implements TableFormat<T>
{
    final private List<E> fields = new ArrayList<E>();
    final private C context;

    public EnumTableFormat(C context, List<E> fieldList) { 
        this.fields.addAll(fieldList);
        this.context = context;
    }

    @Override public int getColumnCount() { return this.fields.size(); }
    @Override public String getColumnName(int column) {
        return this.fields.get(column).getLabel();
    }                       
    @Override public Object getColumnValue(T item, int column) {
        return this.fields.get(column).getValue(this.context, item);
    }
}