@Override  
public View getView(final int position, View convertView, ViewGroup parent) {  
    // TODO Auto-generated method stub  

    if( convertView == null ){
        convertView = inflater.inflate(R.layout.yourListLayout, parent, false);
    }
    Button btchange = (Button)convertView.findViewById(R.id.yourbuttonid);
    btchange.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent i = new Intent(context, Available.class);
            startActivity(i);
        }
    });
    return convertView;
}