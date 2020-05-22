ListView lv = (ListView)findViewById(R.id.MyListView);

lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {

                i = new Intent(ProductActivity.this, ProductDetails.class);


                i.putExtra("keyAapo", (int) lv.getItemIdAtPosition(arg2));

                startActivity(i);

            }

        });