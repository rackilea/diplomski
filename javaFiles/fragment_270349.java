private void loadMoreMessages(String day) {
    mMessagesList.clear();
    CollectionReference loadConnect = db.collection("ROBOTS").document(RobotA).collection(RobotB);
    loadConnect.orderBy("timestamp", Query.Direction.ASCENDING).startAt(day).endBefore(currentDay).addSnapshotListener(new EventListener<QuerySnapshot>() {
        @Override
        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
            if (e != null) {
                Toast.makeText(ChatActivity.this, "Error:" + e.toString(), Toast.LENGTH_SHORT).show();
            }
            for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()) {
                Connections connection = documentChange.getDocument().toObject(Connections.class);

                mConnectionsList.add(connection);
                mAdapter.notifyDataSetChanged();

                conSwipeRefresh.setRefreshing(false);
            }
        }
    });
    loadConnections();
}