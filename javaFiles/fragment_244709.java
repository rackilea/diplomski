private Task<Void> addRating(final DocumentReference restaurantRef, 
                             final Rating rating) {
    // Create reference for new rating, for use inside the transaction
    final DocumentReference ratingRef = restaurantRef.collection("ratings")
            .document();

    // In a transaction, add the new rating and update the aggregate totals
    return mFirestore.runTransaction(new Transaction.Function<Void>() {
        @Override
        public Void apply(Transaction transaction) 
                throws FirebaseFirestoreException {

            Restaurant restaurant = transaction.get(restaurantRef)
                    .toObject(Restaurant.class);

            // Compute new number of ratings
            int newNumRatings = restaurant.getNumRatings() + 1;

            // Compute new average rating
            double oldRatingTotal = restaurant.getAvgRating() * 
                    restaurant.getNumRatings();
            double newAvgRating = (oldRatingTotal + rating.getRating()) /
                    newNumRatings;

            // Set new restaurant info
            restaurant.setNumRatings(newNumRatings);
            restaurant.setAvgRating(newAvgRating);

            // Commit to Firestore
            transaction.set(restaurantRef, restaurant);
            transaction.set(ratingRef, rating);

            return null;
        }
    });
}