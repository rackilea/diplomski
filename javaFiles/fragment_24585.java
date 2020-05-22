listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);


                if (position==0){
                    Intent intent = new Intent(CurrentActivity.this, HandleListClick.class);
                    intent.putExtra("POSITION", position);
                    startActivity(intent);
                }
                   /* HandleListClick handleListClick = new HandleListClick();
                    handleListClick.getItemPosition(0);*/
                }
            }