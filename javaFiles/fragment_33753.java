listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent i = new Intent(MainActivity.this, DadosLista.class);
            i.putExtra("data", array.get(position));
            startActivity(i);
        }
    });