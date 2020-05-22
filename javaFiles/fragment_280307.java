order.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (imageSelected == pancakes.getId()) {
                Toast.makeText(getBaseContext(), "Pancakes added to your order", Toast.LENGTH_SHORT).show();
                food.setText("You've selected Pankcakes");
            }

            if (imageSelected == frenchtoast.getId()) {
                Toast.makeText(getBaseContext(), "French Toast added to your order", Toast.LENGTH_SHORT).show();
                food.setText("You've selected French Toast");
            }

            if (imageSelected == waffles.getId()) {
                Toast.makeText(getBaseContext(), "Waffles added to your order", Toast.LENGTH_SHORT).show();
                food.setText("You've selected Waffles");            
            }

            if (imageSelected == omelet.getID()) {
                Toast.makeText(getBaseContext(), "Omelet added to your order", Toast.LENGTH_SHORT).show();
                food.setText("You've selected Omelet");             
            }
        }
    });