public void onClick(View v) {
        Intent intent = new Intent(TourListActivity.this,
                TourMenuActivity.class);
        String info = tour.toString();
        intent.putExtra(TOUR_INFO, ((Button)v).getTag());
        startActivity(intent);
    }