@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {

        String key = childSnapshot.getKey();

        if(key.equals("clients")) {
            allEvents = childSnapshot.getValue(AllEvents.class);
        } else if(key.equals("manager")) {
            manager = childSnapshot.getValue(Manager.class);
        }
    }
}