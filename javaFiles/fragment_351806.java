public class MyBaseAdapter extends BaseAdapter {

    public Context ba_context;
    public ArrayList<String> listitem = new ArrayList<String>();
    public LayoutInflater inflater;

    public MyBaseAdapter(Context ma_context, ArrayList<String> ma_listitem) {
        super();
        this.ba_context = ma_context;
        this.listitem = ma_listitem;

        inflater = (LayoutInflater) ba_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        Log.e("MyBaseAdapter", "getCount() => " + this.listitem.size());
        return this.listitem.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        Log.i("MyBaseAdapter", "String=>" + this.listitem.get(position).toString());
        if (convertView == null)
            vi = inflater.inflate(R.layout.listview_item_layout, parent, false);

        TextView tvData = (TextView) vi.findViewById(R.id.tvData);

        String data = listitem.get(position).toString();

        tvData.setText(data);

        return vi;
    }
}