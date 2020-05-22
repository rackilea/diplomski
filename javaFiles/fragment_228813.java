public class YMDRenderer extends DefaultTableCellRenderer
{
    private Format formatter = new SimpleDateFormat("yy/MM/dd");

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