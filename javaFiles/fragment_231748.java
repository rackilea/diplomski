final ArrayList<Timeline> timelines = new ArrayList<>();

    mDatabaseTimeline.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            final Timeline timeline = dataSnapshot.getValue(Timeline.class);

            if(timeline != null){

                mDatabaseFriends.child(mAuth.getCurrentUser().getUid()).child("active").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (mAuth.getCurrentUser().getUid().equals(timeline.getUid()) || dataSnapshot.hasChild(timeline.getUid())) {

                            timelines.add(timeline);
                            mTimelineRecycler.setAdapter(new RecyclerAdapter(TimelineFragment.this.getContext(), timelines));

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });