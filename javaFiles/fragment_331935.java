/** class to act as list adapter for rows List */
private static class FourTextListAdapter extends ArrayAdapter<MyDataClass> {

    /** To cache views of item */
    private static class ViewHolder {
        private TextView text1;
        private TextView text2;
        private TextView text3;
        private TextView text4;

        /**
         * General constructor
         */
        ViewHolder() {
            // nothing to do here
        }
    }

    /** Inflater for list items */
    private final LayoutInflater inflater;

    /**
     * General constructor
     *
     * @param context
     * @param resource
     * @param textViewResourceId
     * @param objects
     */
    public FourTextListAdapter(final Context context,
            final int resource,
            final int textViewResourceId,
            final List<User> objects) {
        super(context, resource, textViewResourceId, objects);

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View itemView = convertView;
        ViewHolder holder = null;
        final MyDataClass item = getItem(position);

        if(null == itemView) {
            itemView = this.inflater.inflate(R.layout.four_texts_item, parent, false);

            holder = new ViewHolder();

            holder.text1 = (TextView)itemView.findViewById(R.id.text1);
            holder.text2 = (TextView)itemView.findViewById(R.id.text2);
            holder.text3 = (TextView)itemView.findViewById(R.id.text3);
            holder.text4 = (TextView)itemView.findViewById(R.id.text4);

            itemView.setTag(holder);
        } else {
            holder = (ViewHolder)itemView.getTag();
        }

        holder.text1.setText(item.getText1());
        holder.text2.setText(item.getText2());
        holder.text3.setText(item.getText3());
        holder.text4.setText(item.getText4());

        return itemView;
    }
}