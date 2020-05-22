@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent i = new Intent(ListActivity.this, MainActivity.class);
            i.putExtra("keyText","value to be passed!");
            startActivity(i);
        }