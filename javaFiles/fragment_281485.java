list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long Id) {

            Intent intent = new Intent(AdminList.this, LaunchActivity.class);
            startActivity(intent);
        }
    });