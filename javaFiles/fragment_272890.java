LinearLayout linear=(LinearLayout)findviewbyId(R.id.linear);
 LayoutInflater layoutInflater = 
            (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View addView = layoutInflater.inflate(R.layout.dynamicabout, null);
            TextView textOut = (TextView)addView.findViewById(R.id.aboutcontent);
            textOut.setText(strings.get(index));
linearview.addView(addView);