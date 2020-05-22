DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

Query query = reference.child("TRANSACTIONS").orderByChild("Transaction_Type").equalTo("IN");
query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {
            int sum = 0;
            for (DataSnapshot snapShot : dataSnapshot.getChildren()) {
                Transaction transaction = snapShot.getValue(Transaction.class);
                int amount = Integer.parseInt(transaction.Transaction_Amount);
                sum = sum + amount;
            }
            textView.setText("")
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});