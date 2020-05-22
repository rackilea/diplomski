@Override
public View getView(int position, View convertView, ViewGroup parent) {
  LayoutInflater inflater = (LayoutInflater) context
      .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
  TextView textView = (TextView) rowView.findViewById(R.id.label);
  ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
  textView.setText(values[position]);
  // Change the icon for Windows and iPhone
  String s = values[position];
  if (s.startsWith("Windows7") || s.startsWith("iPhone")
      || s.startsWith("Solaris")) {
    imageView.setImageResource(R.drawable.no);
  } else {
    imageView.setImageResource(R.drawable.ok);
  }

  return rowView;
}