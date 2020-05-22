DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference imageUrlsRef = rootRef.child("imageUrls");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> urlList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String url = ds.getKey();
            urlList.add(url);
        }

        int urlCount = urlList.size();
        int randomNumber = new Random().nextInt(urlCount);
        List<String> randomUrlList = new ArrayList<>();
        for (int i=1; i<=5; i++) {
            randomUrlList.add(urlList.get(randomNumber));
            //Set image to ImageView
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
imageUrlsRef.addListenerForSingleValueEvent(valueEventListener);