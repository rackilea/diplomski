protected void loadData(){
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Events").child("Music");
    ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Iterable<DataSnapshot> recordsSnaphots = dataSnapshot.getChildren();

            int count = (int) dataSnapshot.getChildrenCount();
            int i = 0;

            String[] names = new String[count];
            String[] descriptions = new String[count];
            String[] locations = new String[count];
            String[] times = new String[count];

            for(DataSnapshot recordSnapshot: recordsSnaphots){
                MusicRecord record = recordSnapshot.getValue(MusicRecord.class);
                if(record != null) {
                    names[i] = record.eventName;
                    descriptions[i] = record.eventDescription;
                    locations[i] = record.location;
                    times[i] = record.date;

                    i++;
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}