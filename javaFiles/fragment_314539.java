public class EnumListBox<T extends Enum<?>> extends ListBox implements LeafValueEditor<T>
{
    private final Class<T> mClazz;

    public EnumListBox(Class<T> clazz) {
        mClazz = clazz;
    }

    @Override
    public T getValue()
    {
        int ndx = getSelectedIndex();
        String val = getValue(ndx);
        return Enum.valueOf(mClazz, val);
    }
}