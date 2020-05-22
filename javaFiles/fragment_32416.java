adapter=new ArrayAdapter<String>(MainActivity.this, 
                android.R.layout.simple_list_item_1,android.R.id.text1,parcedCountry); //UPDATE HERE
        list.setAdapter(adapter);
         try
         {
                 InputStream is;
                 is=getAssets().open("countries.xml");
                 BufferedReader r = new BufferedReader(new InputStreamReader(is));
                 StringBuilder total = new StringBuilder();
                 String line;
                 while ((line = r.readLine()) != null)
                 {
                         total.append(line);
                 }

                 //Log.e("File",""+total.toString()); 

                 parseCountries(total.toString());

                 adapter.notifyDataSetChanged(); //UPDATE HERE

         }
         catch (Exception e) 
         {
                 // TODO: handle exception
         }