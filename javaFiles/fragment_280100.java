public class PhoneNumberRenderer extends DefaultTableCellRenderer
{
    public PhoneNumberRenderer()
    {
        super();
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void setValue(Object value)
    {
        if (value instanceof PhoneNumber)
        {
            PhoneNumber pn = (PhoneNumber)value;
            value = "(" + pn.areaCode + ") " + pn.prefix" + "...";
        }

        super.setValue(value);
    }
}