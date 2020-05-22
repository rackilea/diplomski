listViewSaves.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        RigSaves rigSaves = savesList.get(position);

         // Gaming option 
        if( rigSaves.getRigType().equals("Gaming") && rigSaves.getRigPrice().equals("Under 500") ){
        Intent myIntent = new Intent(MainActivity.this, Game_500.class);
        startActivity(myIntent);
        }

        if( rigSaves.getRigType().equals("Gaming") && rigSaves.getRigPrice().equals("Under 1000") ){
        Intent myIntent = new Intent(MainActivity.this, Game_1000.class);
        startActivity(myIntent);
        }

        // personal option 
        if( rigSaves.getRigType().equals("Personal Use") && rigSaves.getRigPrice().equals("Under 500") ){
          // start activity you want to start
        }

        if( rigSaves.getRigType().equals("Personal Use") && rigSaves.getRigPrice().equals("Under 1000") ){
           // start activity you want to start
        }

    }
});