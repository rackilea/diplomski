ListView ml=(ListView) findViewById(R.id.listview);

     FirebaseListAdapter<String> adapter=new FirebaseListAdapter<String>(this,String.class,android.R.layout.simple_list_item_1,myRef.child("Message"))
     {
         @Override
         protected void populateView(View v, String model, int position) {
             TextView tv=(TextView) v.findViewById(android.R.id.text1) ;
             tv.setText(model);

         }
     };
     ml.setAdapter(adapter) ;