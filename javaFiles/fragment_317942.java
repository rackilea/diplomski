public View getView(final int position, View convertView,
                    ViewGroup parent) {
    LayoutInflater inflater = getLayoutInflater();
                View row = inflater.inflate(R.layout.vehicals_details_row, parent,
                        false);
    Button btnView = (Button)  row.findViewById(R.id.button1);
    btnView .setOnClickListener(new OnClickListener() {

     @Override
       public void onClick(View v) 
       {
           // Your code that you want to execute on this button click
       }

    });