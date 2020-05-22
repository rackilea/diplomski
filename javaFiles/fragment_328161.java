myref.child("users").child(addingpatient.getUserId()).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {
            Users patient = dataSnapshot.getValue(Users.class);

            name.add(patient.getName()+" "+patient.getSurname());

            sicks.add(patient.getSicks());
            patientuid.add(patient.getUserId());
        }
        PatientSelectionAdapter adapter= new PatientSelectionAdapter(getContext(),name,sicks,hastauid);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onCancelled(DatabaseError error) {}
});