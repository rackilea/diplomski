String[] color = {"blue", "brown", "black", "red", "green", "gray", "violet", "white", "orange"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, color);
    actv.setAdapter(adapter);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });