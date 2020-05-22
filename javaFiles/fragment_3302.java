questionsRef = FirebaseDatabase.getInstance().getReference().child("questions").child("DE");

questionsRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int questionCount = (int) dataSnapshot.getChildrenCount();
        int rand = random.nextInt(questionCount);
        Iterator itr = dataSnapshot.getChildren().iterator();

        for(int i = 0; i < rand; i++) {
            itr.next();
        }
        childSnapshot = (DataSnapshot) itr.next();
        question = childSnapshot.getValue(Question.class);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});