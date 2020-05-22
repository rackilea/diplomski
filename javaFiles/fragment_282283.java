public void getusersinfo(){
    studentRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            User user = dataSnapshot.getValue(User.class);
            String email = user.getName();
            String grade = user.getGrade();
            user_info = ("Name " + email + "Grade" + grade);
            list.add(user_info);               
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}