listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

             @Override
             public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                 Log.v("TOMTEST", "Clicked");   
                 Toast.makeText(getApplicationContext(), "Clicked : "+position, Toast.LENGTH_LONG).show();

               }
           });