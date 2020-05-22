class ButtonRowAdapter extends BaseAdapter {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= convertView;
        if (v == null) {
            LayoutInflater vi= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v= vi.inflate(R.layout.row_layout, null);
        }
        YourButtonClass c= getItem(position);
        ((ImageView) v.findViewById(R.id.imageView1)).setImageResource(c.getImage());
        ((TextView) v.findViewById(R.id.textView1)).setText(c.getText());

        return v;
    }

    @Override
    public int getCount() {
        return <"button" count>;
    }

    @Override
    public Object getItem(int position) {
        return <"button" at position position>;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}