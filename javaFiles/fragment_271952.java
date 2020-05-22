public class IntegerRenderer extends DefaultTableCellRenderer
{
    private Format formatter = new NumberFormage.getIntegerInstance();

    public IntegerRenderer()
    {
        setHorizontalAlignment( SwingConstants.RIGHT );
    }

    public void setValue(Object value)
    {
        //  Format the Object before setting its value in the renderer

        try
        {
            if (value != null)
                value = formatter.format(value);
        }
        catch(IllegalArgumentException e) {}

        super.setValue(value);
    }
}