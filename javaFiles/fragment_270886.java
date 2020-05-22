class RatingAdapter extends ArrayAdapter<String> 
{
    Context ctx;
    LayoutInflater inflater;
    TextView stationName;
    RatingBar star;
    ArrayMap<String, Boolean> rowLayout = ArrayMap<String, Boolean>();

    public RatingAdapter(Context context, int textViewResourceId, String[] objects) 
    {
        super(context, textViewResourceId, objects);
        ctx = context;
        inflater = LayoutInflater.from(context);

        for (String rowText : (String) objects)
          rowLayout.put(rowText, false);  // Supposing all your initial stars will be off
    }