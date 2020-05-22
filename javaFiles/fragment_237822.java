public static final List<DateFormat> dateFormats = new ArrayList<DateFormat>()
{
    {
        add(new SimpleDateFormat("M/dd/yyyy HH:mm"));
        add(new SimpleDateFormat("dd.M.yyyy HH:mm"));
        add(new SimpleDateFormat("dd.MMM.yyyy HH:mm"));
        add(new SimpleDateFormat("dd-MMM-yyyy HH:mm"));
        add(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        add(new SimpleDateFormat("M/dd/yyyy"));
        add(new SimpleDateFormat("dd.M.yyyy"));
        add(new SimpleDateFormat("dd.MMM.yyyy"));
        add(new SimpleDateFormat("dd-MMM-yyyy"));
        add(new SimpleDateFormat("yyyy-MM-dd"));
    }
};