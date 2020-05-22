db.collection("Users").whereEqualTo("email",user.getEmail())
                             .get()
                             .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                 @Override
                                 public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                                    for(DocumentSnapshot ds : queryDocumentSnapshots)   {
                                        User user = ds.toObject(User.class);
                                        List<String> urlList = user.getPicturesUrls();
                                    }

                                }
                             });