final Intent openResultActivity = new Intent(this,MainActivity.class);
        final EditText searchQuery = (EditText) findViewById(R.id.search_edit_text);

        Button searchButton=(Button)findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String searchQueryString=searchQuery.getText().toString();
                Log.v("SearchinSBA",searchQueryString);

                Bundle bundle=new Bundle();
                bundle.putString("searchQuery",searchQueryString);
                openResultActivity.putExtras(bundle);
                startActivity(openResultActivity);
            }
        });