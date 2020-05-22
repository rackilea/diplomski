Set<Destination> hashset = new HashSet<>(); 
        hashset.addAll(destinationArrayList); 
        destinationArrayList.clear(); 
        destinationArrayList.addAll(hashset);

        ListView listview = (ListView)findViewById(R.id.list);
        adapter = new MainAdapter(getApplicationContext(), R.layout.row, destinationArrayList);

        listview.setAdapter(adapter);