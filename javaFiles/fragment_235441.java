public class PhotoAdapter extends ArrayAdapter<Photo> {
    LayoutInflater mInflater;

    public PhotoAdapter(Context context, int textViewResourceId,
            ArrayList<Photo> objects) {
        super(context, textViewResourceId, objects);
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Photo i = get(position);
        View v = convertView;

        if (v == null) {
            v = mInflater.inflate(R.layout.listview_row, null);
            // Initialize your ViewHolder here!
        }

        // Update your TextViews, ImageViews, etc here
        ...
    }
}