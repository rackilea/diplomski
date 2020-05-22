public void updateList() {


        feedListView= (ListView) findViewById(R.id.custom_list);
        feedListView.setVisibility(View.VISIBLE);
        progressbar.setVisibility(View.GONE);
        feedListView.setAdapter(new CustomListAdapter(this, feedList));

        final ListView V = (ListView) findViewById(R.id.contato_list);
        //V.setVisibility(View.VISIBLE);
        V.setAdapter(new ContatosListAdapter(this, contatoList));



        feedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Object o = V.getItemAtPosition(position);
                ClientesContatosModel newsData = (ClientesContatosModel) o;


                Intent intent = new Intent(FeedListActivity.this, FeedDetailsActivity.class);
                intent.putExtra("feed", newsData);
                startActivity(intent);

            }

        });



    }