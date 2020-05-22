Button btnMap = (Button) findViewById(R.id.map);
        btnMap.setOnClickListener(new View.OnClickListener() {
        Class ourClass; 
            public void onClick(View v) {

            Intent i = new Intent(GulliverActivity.this, Maps.Class);
            startActivity(i);

});