public class MainActivity extends Activity {

    private Firebase mRef;
    private HashMap<Firebase, ValueEventListener> mListenerMap;

    @Override
    protected void onStart() {
        super.onStart();

        mRef = new Firebase("https://<your-firebase-app>/myChatRooms/testUser");

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    ValueEventListener listener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // do your thing here
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    };
                    mListenerMap.put(postSnapshot.getRef(), listener);
                    Firebase childRef = mRef.child("chatRoomMessageCount").child(postSnapshot.getKey());
                    childRef.addValueEventListener(listener);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        for (Map.Entry<Firebase, ValueEventListener> entry : mListenerMap.entrySet()) {
            Firebase ref = entry.getKey();
            ValueEventListener listener = entry.getValue();
            ref.removeEventListener(listener);
        }
    }
}