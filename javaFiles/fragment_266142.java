public class PhoneAdapter extends BaseAdapter {
    private Context context;

    public PhoneAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {

        convertView = View.inflate(context, R.layout.item, null);


        TextView mCode = (TextView) convertView.findViewById(R.id.code);

        Switch mButton = (Switch) convertView.findViewById(R.id.toggleButton);

        mCode.setText("item"+i+1);
        if (i == 2 || i == 3 || i == 6)
            mButton.setVisibility(View.VISIBLE);

        return convertView;
    }}