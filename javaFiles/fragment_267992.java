public void updateCount(DatabaseReference database){
    database.runTransaction(new Handler() {
        @Override
        public Result doTransaction(MutableData mutableData) {

            //Currently no value in eventAmount
            if(mutableData.getValue() == null){
                mutableData.setValue(1);
            }
            else{
               mutableData.setValue(Integer.parseInt(mutableData.getValue().toString()) + 1);
            }
            return Transaction.success(mutableData);
        }

        @Override
        public void onComplete(DatabaseError databaseError, boolean b,
            DataSnapshot dataSnapshot) {
                //Probably log the error here.
        }
    });
}