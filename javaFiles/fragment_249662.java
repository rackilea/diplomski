private class MyAdapter extends ArrayAdapter<String> {
    Typeface font;

    public MyAdapter(Context context, int resource, int textViewResourceId,
            String[] string) {
        super(context, resource, textViewResourceId, string);
        font = Typeface.createFromAsset(context.getAssets(),"myFont.ttf");
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.show_all, parent, false);
        String[] item = getResources().getStringArray(R.array.food_cal);
        TextView tv = (TextView) row.findViewById(R.id.textView1);
        try {
            tv.setTypeface(font);
        } catch (Exception e) {
            Log.d("Alireza", e.getMessage().toString());
        }

        tv.setText(item[position]);
        return row;
    }
}