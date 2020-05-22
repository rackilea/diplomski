ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
    @Override
    public void onRatingChanged(RatingBar bar, float rating, boolean user) {
        promptSubmitStar();
    }
});