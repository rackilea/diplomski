ParseQuery<ParseUser> query = ParseUser.getQuery();
query.whereNotEqualTo("objectId", ParseUser.getCurrentUser().getObjectId());
// users with Gender = currentUser.Looking_Gender
query.whereEqualTo("Gender", userLookingGender);
// users with Looking_Gender = currentUser.Gender
query.whereEqualTo("Looking_Gender", userGender);