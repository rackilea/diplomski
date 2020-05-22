public class AdapterClass extends ArrayAdapter<String>
{
    private LayoutInflater inflater;
    private FragmentAListener listener;

    public AdapterClass(Context context, String[] friendList, FragmentAListener listener) {
        super(context, 0, friendList);
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
            holder = new Holder(view);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        String itemName = getItem(position);
        holder.textView.setText(itemName);
        holder.button.setText(itemName);
        holder.button.setTag(itemName);
        return view;
    }

    private class Holder
    {
        private TextView textView;
        private Button button;

        public Holder(View row) {
            textView = (TextView) row.findViewById(R.id.textView);
            button = (Button) row.findViewById(R.id.button);
            button.setOnClickListener(onClickListener);
        }
    }

    private OnClickListener onClickListener = new OnClickListener()
    {
        @Override
        public void onClick(View v) {
            listener.onListItemButtonClicked(v.getTag().toString());
        }
    };
}