ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, value1) {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            String value = getItem(position);
            if (value.equals("0")) {
                view.setBackgroundColor(Color.GRAY);
            } else {
                view.setBackgroundColor(Color.RED);
            }
           // Updating the text color.
           TextView textView= (TextView) view;
           textView.setTextColor(Color.BLACK);
            return view;
        }
    };