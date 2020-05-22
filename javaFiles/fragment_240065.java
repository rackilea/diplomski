public class ExampleAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<ParseObject> objects;
    private final boolean[] activated;

    public ExampleAdapter(Context context, List<ParseObject> objects) {
        this.inflater = LayoutInflater.from(context);
        this.objects = objects;
        this.activated = new boolean[objects.size()]; 
    }

    public void showProgressBar(int position, boolean visible) {
        this.activated[position] = visible;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.objects.size();
    }

    @Override
    public ParseObject getItem(int position) {
        return this.objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // If the convertView is null, we need to inflate a new one
        if(convertView == null) {
            // We inflate the view with your layout
            convertView = inflater.inflate(R.layout.myrow, parent, false);

            // Here we create a view holder object which keeps a 
            // reference to the Views in this row so we have to
            // perform the expensive findViewById() only once
            ViewHolder holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.my_prog = (ProgressBar) convertView.findViewById(R.id.my_prog);

            // The view holder is set as tag to the view so we can access it later
            convertView.setTag(holder);
        }

        // We retrieve the ParseObject for the current position
        ParseObject parseObject = getItem(position);

        // And get the view holder from the View
        ViewHolder holder = (ViewHolder) convertView.getTag();

        // We read the data we need from the ParseObject
        String name = parseObject.get("name");

        // And here is the visibility logic
        int progressBarVisibility = this.activated[position] ? View.VISIBLE : View.GONE;
        int textViewVisibility = this.activated[position] ? View.GONE : View.VISIBLE;

        // Now we set the data to the Views through the view holder
        holder.text.setText(name);
        holder.text.setVisibility(textViewVisibility);
        holder.my_prog.setVisibility(progressBarVisibility);

        return convertView;
    }

    // This is our view holder class. It keeps a reference to the Views 
    // inside each row so we have to perform the expensive
    // findViewById() only once
    private class ViewHolder {
        public TextView text;
        public ProgressBar my_prog;
    }
}