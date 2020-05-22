@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    ViewHolder holder; // to reference the child views for later actions

    if (v == null) {
        LayoutInflater vi = 
            (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.mainrow, null);
        // cache view fields into the holder
        holder = new ViewHolder();
        holder.nameText = (TextView) v.findViewById(R.id.nameText);
        holder.priceText = (TextView) v.findViewById(R.id.priceText);
        holder.changeText = (TextView) v.findViewById(R.id.changeText);
        // associate the holder with the view for later lookup
        v.setTag(holder);
    }
    else {
        // view already exists, get the holder instance from the view
        holder = (ViewHolder) v.getTag();
    }
    // no local variables with findViewById here

    // use holder.nameText where you were 
    // using the local variable nameText before

    return v;
}

// somewhere else in your class definition
static class ViewHolder {
    TextView nameText;
    TextView priceText;
    TextView changeText;
}