public void populate(ArrayList<String> array, ArrayList<String> array2) {
        ListView showList = (ListView) findViewById(R.id.listView1);
        SchedAdapter shows = new SchedAdapter(getApplicationContext(),
                R.layout.rowlayout, array, array2);
        showList.setAdapter(shows);
        showList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                    final int position, long id) {

               Toast.makeText(getApplicationContext(), array2.get(position),
                        Toast.LENGTH_SHORT).show();
               Toast.makeText(getApplicationContext(), array.get(position),
                         Toast.LENGTH_SHORT).show();
            }

        });
    }