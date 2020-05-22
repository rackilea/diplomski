WeatherAdapter adapter = new WeatherAdapter(this,R.layout.listview_header_row, weather_data);
        listView1 = (ListView)findViewById(R.id.listView1);
        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        //listView1.addHeaderView(header);
        listView1.setAdapter(adapter);  
        listView1.setClickable(true);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

          @Override
          public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Dialog  dialog = new Dialog (Activity2.this);
                dialog.setContentView(R.layout.dialogxml);
                dialog.setCancelable(true);
                ImageView dcover=(ImageView) dialog.findViewById(R.id.dimageView1);
                TextView dtitle = (TextView) dialog.findViewById(R.id.dtextView1);
                TextView dyear = (TextView) dialog.findViewById(R.id.dtextView2);
                TextView ddirector = (TextView) dialog.findViewById(R.id.dtextView3);
                TextView drating = (TextView) dialog.findViewById(R.id.dtextView4);
                TextView len1 = (TextView) dialog.findViewById(R.id.textView77);
                Button postbutton=(Button) dialog.findViewById(R.id.buttonfb);

                InputStream is;
                try {
                    is = (InputStream) new URL(full_data[position][0]).getContent();
                    Drawable dd = Drawable.createFromStream(is, "src name");
                    dcover.setImageDrawable(dd);
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                dtitle.setText("Name: "+full_data[position][1]);
                dyear.setText("Year: "+full_data[position][2]);
                ddirector.setText("Director: "+full_data[position][4]);
                drating.setText("Rating: "+full_data[position][3]+"/10");
                dialog.show();
            postbutton.setOnClickListener(new View.OnClickListener() { 
                    @Override
                    public void onClick(View v) {

                    }
                  });


          }