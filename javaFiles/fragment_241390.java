LayoutInflater rating = LayoutInflater.from(RatingActivity.this);
final View ratingView = rating.inflate(R.layout.rating_layout, null);

AlertDialog.Builder adb = new AlertDialog.Builder(RatingActivity.this);               
adb.setTitle("Rate us!);
adb.setView(ratingView);

AlertDialog ratingbar = adb.create();