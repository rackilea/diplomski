for (i = 9; i <= 18; i++) {
        String time = Integer.toString(i);
        final String MonTime = "Mon" + i;

        dbRef.child("Monday").child(time).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String module = dataSnapshot.child("Module").getValue(String.class);
                String room = dataSnapshot.child("Room").getValue(String.class);
                int id = getResources().getIdentifier(MonTime, "id", getPackageName());
                TextView Monday = (TextView) findViewById(id);
                Monday.setText(MonValue);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
}