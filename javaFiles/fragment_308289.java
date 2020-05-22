@Override
public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view = super.getView(position, convertView, parent);
    TextView textView = (TextView) view.findViewById(android.R.id.text1);
    textView.setLines(5);
    return view;
}