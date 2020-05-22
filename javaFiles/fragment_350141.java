public void searchContacts(final String emailInput){
    DatabaseReference users = FirebaseDatabase.getInstance().getReference("users");
    users.orderByChild("email").equalTo(emailInput).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            List<String> list = new ArrayList<>(); //Create the list
            for (DataSnapshot userSnapshot: dataSnapshot.getChildren()){
                String email = userSnapshot.child("email").getValue(String.class);
                if(email.equals(emailInput)){
                    users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("contacts").child(emailInput).setValue(true);
                    list.add(email); //Add the email the list
                }
            }

            //Do what you need to do with list
        }
    }
}