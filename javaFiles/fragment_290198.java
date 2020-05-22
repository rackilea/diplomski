final RestaurantModel local = model;
        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent fragmentintent = new Intent(RestaurantList.this, main_intermediate.class);
                fragmentintent.putExtra("RestaurantId", adapter.getRef(position).getKey());
                startActivity(fragmentintent);