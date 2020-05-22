ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.fonts_simple_row,value) {
@Override
 public View getView(int position, View convertView,ViewGroup parent) {
     View view = super.getView(position, convertView, parent);
     TextView textView = (TextView) view.findViewById(R.id.rowTextView); 
     textView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/" + fonts[position] + ".ttf"));
     return view;
 }
 };

fontsListView.setAdapter(arrayAdapter);