private void updateTextView(ArrayList<Restaurant> restaurants, RestaurantAdapter itemsAdapter) {

                Date date = new Date();   // given date
                Calendar calendar = Calendar.getInstance(); // creates a new calendar instance
                calendar.setTime(date);   // assigns calendar to given date
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                int hour = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
                int minutes = calendar.get(Calendar.MINUTE);        // gets hour in 12h format
                TextView title = (TextView) findViewById(R.id.openTag);
                if(hour>=21) {
                    restaurants.get(0).changeOpenTag("Closed");
                    itemsAdapter.notifyDataSetChanged();
                }
                if (hour>= 9 && hour <= 15) {
                    title.setText("Lunch");
                }
                else {
                    title.setText("Dinner");
                }
    }