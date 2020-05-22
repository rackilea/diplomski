findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        float rating = ratingBar.getRating();
        mRatingBarCh.child("rating").setValue(String.valueOf(rating));
    }
});