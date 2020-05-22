List<String> stringList = new ArrayList<>();
      stringList.add("hello");
      stringList.add("hell");
      stringList.add("help");
      stringList.add("heck");
      stringList.add("dude");
      adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, stringList);
      AutoCompleteTextView ac = (AutoCompleteTextView)findViewById(R.id.auto_complete);
      ac.setThreshold(1);
      ac.setAdapter(adapter);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Filter f = adapter.getFilter();
            f.filter("", new Filter.FilterListener() {
               @Override
               public void onFilterComplete(int count) {
                  int count2 = adapter.getCount();
                  mainText.setText("Count is: " + count);
                  adapter.add("hellraiser");
               }
            });
         }
      });

      mainText = (TextView) findViewById(R.id.main_text);