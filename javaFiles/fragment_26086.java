listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?>adapter, View v, int position, long id) {

            String item = yourData.getPosition(position).getName();

            Intent intentProduct = new Intent(Scrollable.this, ProductDetail.class);

            intentProduct.putExtra("Key", item);

            startActivity(intentProduct);

        }
    });