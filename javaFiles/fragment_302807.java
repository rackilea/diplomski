class StockArrayAdapter extends ArrayAdapter
{
    Context myContext;
    ArrayList<Stock> stocks;
    int myLayout;
    LayoutInflater inflator;

    public StockArrayAdapter(Context context, int resource) {
        super(context, resource);
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        initialize(context, resource, stocks);
    }

    public StockArrayAdapter(Context context, int resource, ArrayList<Stock> stocks) {
        super(context, resource, stocks);

        initialize(context, resource, stocks);

    }

    private void initialize(Context context, int resource, ArrayList<Stock> objects) {
        myContext = context;
        myLayout = resource;
        stocks = objects;
        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = inflator.inflate(myLayout, parent, false);
        TextView nameTextView = (TextView) rowView.findViewById(R.id.nameTextView);
        TextView lastTextView = (TextView) rowView.findViewById(R.id.lastTextView);
        TextView changeTextView = (TextView) rowView.findViewById(R.id.changeTextView);
        nameTextView.setText(stocks.get(position).CompanyName);
        lastTextView.setText(stocks.get(position).LastTrade);
        changeTextView.setText((stocks.get(position).Change));

        return rowView;
    }
}