private void registerCallClickBack() {
    // TODO Auto-generated method stub
    ListView list = (ListView)findViewById(R.id.listView1);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View viewClicked, int position,
                long id) {
            // TODO Auto-generated method stub
            //String message = "You have chosen the " + id + "item";
            //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent("package.Activity name");
            startActivity(intent);
        }
    });
}