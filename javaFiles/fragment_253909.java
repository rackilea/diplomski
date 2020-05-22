ParseUser currentUser=ParseUser.getCurrentUser();
ParseObject post = new ParseObject("Request");
post.put("data", "data");
post.put("status", "new");
post.put("user1", currentUser);
post.saveInBackground();