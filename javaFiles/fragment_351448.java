public View getView(int position, View convertView, ViewGroup parent) {
    convertView = inflater.inflate(R.layout.yourLayout, null);
    convertView.findViewById(R.id.imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // your click handling code here. 
            }
        });
     return convertView;
}