public class ExampleAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<Item> items;

    private ExampleAdapter(Context context, List<Item> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Item getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.items.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Item item = getItem(position);

        if(convertView == null) {
            // If convertView is null we have to inflate a new layout
            convertView = this.inflater.inflate(R.layout.example_list_item, parent, false);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvDisplayText = (TextView) convertView.findViewById(R.id.tvDisplayText);
            viewHolder.tvMeta = (TextView) convertView.findViewById(R.id.tvMeta);

            // We set the view holder as tag of the convertView so we can access the view holder later on.
            convertView.setTag(viewHolder);
        }

        // Retrieve the view holder from the convertView
        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        // Bind the values to the views
        viewHolder.tvDisplayText.setText(item.getDisplayText());
        viewHolder.tvMeta.setText(item.getMeta());

        return convertView;
    }
}