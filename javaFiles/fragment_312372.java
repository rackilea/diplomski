public Observable<UserModel> UserModel getUserFromId(String userId) {
    return Observable.create(new ObservableOnSubscribe<UserModel>() {
        @Override
        public void subscribe(@NonNull ObservableEmitter<UserModel> e) throws Exception {
            dbRef.child("status").child(userId).addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get user value
                            UserModel user = dataSnapshot.getValue(UserModel.class);
                            e.onNext(user);
                            // ...
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.d("TAG", "getUser:onCancelled", databaseError.toException());
                            e.onError(databaseError);
                            // ...
                        }
                    });
        }
    });
}