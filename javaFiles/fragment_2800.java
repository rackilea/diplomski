@Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            Event e = snapshot.getValue(Event.class);
            eventid = e.getEvent_id();
        }

        Intent intent = new Intent(NearbyEventsActivity.this, EventDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("eventid", eventid);
        intent.putExtras(bundle);
        if (eventid != null) {
         startActivity(intent);
        }
    }