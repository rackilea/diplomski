public class NewsAdapter extends ArrayAdapter{
    private static final String DEBUG_TAG = "NEWSADAPTER";
    private LayoutInflater inflater;
    ArrayList<String> items;

    public NewsAdapter(Activity activity, ArrayList<String> items){

        inflater = activity.getWindow().getLayoutInflater();
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

       View v = convertView
        if(v == null)
            v = inflater.inflate(R.layout.news_feed, parent, false);
        TextView txtTitle = (TextView) v.findViewById(R.id.title);
        txtTitle.setText(items.get(position));
        return v;
    }
}