private class MyAdapter extends ArrayAdapter {

    private String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
        "Linux", "OS/2" };

    private int[] myImagesSaved = new Int[] { R.drawable.image1, 
                                              R.drawable.image2, ... }

    public MyAdapter (Context context, int textViewResourceId) {
       super(context, textViewResourceId, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row, null);
        }              

        TextView text = (TextView) v.findViewById(R.id.icon);
        ImageView image = (TextView) v.findViewById(R.id.label);

        if (text != null) 
           text.setText(values[position]);                            }

        if(image != null)
           image.setBackgroundResource(myImagesSaved[position]);

        return v;
    }
}