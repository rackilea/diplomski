public class Search
{
    ArrayList<TextView> results = new ArrayList<TextView>();

    public void init(Context context)
    {
        TableRow altNameTr = new TableRow(context);
        TextView tv;

        for(int i=0; i<5; i++)
        {
            tv = new TextView(context);
            results.add(tv);
            altNameTr.addView(tv);
        }
        table.addView(altNameTr);
    }

    public void fillSearchResults()
    {
        for(int i=0; i<results.size(); i++) 
        {
            results.get(i).setText("Whatever you need to set here"); 
        }
    }
}