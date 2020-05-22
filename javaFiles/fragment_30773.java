gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {

                if(position == 0){
                   Intent i = new Intent(MainActivity.this, NextActivity1.class);
                   startActivity(i);
                }
                else if(position == 1){
                   Intent i = new Intent(MainActivity.this, NextActivity2.class);
                   startActivity(i);
                }
                // Do as above for rest of the positions
            }
        });