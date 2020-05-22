String columns = <COLUMNS>;
pw.write(columns);

patientRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
            Object object = postSnapshot.getValue(Object.class);
            String value1 = object.getValue1(); 
            ...
            String row = value1 + ", " + value2 + ", "...;
            pw.println(row);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

pw.close();