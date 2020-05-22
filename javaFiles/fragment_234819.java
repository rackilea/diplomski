list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value=list.getItemAtPosition(position).toString();
                if (position == 0) {
                    Intent i = new Intent(MainActivity.this, Apstate.class);
                    i.putExtra("ListView_value",value);
                    startActivity(i);
                }
                if (position == 1)
                {
                    Intent i1 = new Intent(MainActivity.this,Birla.class);
                    i1.putExtra("ListView_value",value);
                    startActivity(i1);
                }
                ....// same like the above do for all
                ...
                ...
            }

        });