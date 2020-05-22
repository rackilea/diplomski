textView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
            if(index == 1){
                Intent i = new Intent (MainActivity.this, SecondActivity.class);
                i.putExtra("KEY", presidents[index]);
                startActivity(i);
            }
        }
    });