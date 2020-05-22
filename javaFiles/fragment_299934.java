lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick((AdapterView<?> parent, 
            View view, 
            int position, 
            long id)) {


        String item = lv.getItemAtPosition(position);
        Toast.makeText(this,"You selected : " + item,Toast.LENGTH_SHORT).show();


        }
    });