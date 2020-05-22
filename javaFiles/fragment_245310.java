adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, values){
               @Override
               public View getView (int position, View convertView, ViewGroup parent){
                   View v = super.getView(position, convertView, parent);
                 if(position%2==0){
                   ((TextView)v.findViewById(R.id.product_name)).setTextColor(color.BlueViolet);
                 }
                   return v;
               }
           };
           listView.setAdapter(adapter);