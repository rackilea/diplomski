public void RunTransactionFor(String offer_id){


//first refer to your offers
DatabaseReference offers_ref = FirebaseDatabase.getInstance().getReference().child("offers").child(offer_id);

//run a transaction (a transaction is fast it reads and writes directly)

offer_ref.runTransaction(new Transaction.Handler() {
        @Override
        public Transaction.Result doTransaction(MutableData mutableData) {
            //this is a ref to the offer class 
            Offer offer = mutableData.getValue(Offer.class);

            if (offer == null) {
                return Transaction.success(mutableData);
            }
            if(offer.taken == false){
             //take the offer
             offer.taken = true;
             //show a message
             Toast.makeText(context, "you took the offer",...).show();
             //now you can remove the offer
             offers_ref.setValue(null);//or delete it your way 



            }else{
             //too late the offer is taken
             Toast.makeText(context, "too late the offer is gone",...).show(); 
             //do nothing  
            } 

            // Set value and report transaction success
            mutableData.setValue(offer);
            return Transaction.success(mutableData);
        }

        @Override
        public void onComplete(DatabaseError databaseError, boolean b,
                               DataSnapshot dataSnapshot) {
            // Transaction completed 

        }
    });

}