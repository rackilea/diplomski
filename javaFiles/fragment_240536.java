AutoCompleteTextView search = (AutoCompleteTextView) findViewById(R.id.search);

search.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Do what ever you want
                              (AutoCompleteTextView) findViewById(R.id.search).setText(""); 
                }
            });