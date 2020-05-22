lv.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {
        // When clicked, show a toast with the TextView text
        Toast.makeText(getApplicationContext(), "View Product",
            Toast.LENGTH_SHORT).show();

        Product product = pl.getList().get(position);
        System.out.println("getName() : "+product.getName());


        Intent intent = new Intent(ProductListView.this, ProductDetails.class);
        intent.putExtra("name", product.getName());
              //Add other values alos in Extras....

        ProductListView.this.startActivity(intent);
        }
    });