Query x = mStoreBaseRef.collection(USERS_LABEL).whereEqualTo("user_id", mPollCreatorID);
x.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        for (DocumentSnapshot d : task.getResult()){
            Log.v("ID", d.getId());
            User user = d.toObject(User.class);
            Log.v("USER", user.getUser_id());
            //I need to add the document here of the unique key
            mStoreBaseRef.collection(USERS_LABEL).add(followersMap);
        }
    }