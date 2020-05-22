<T extends BaseAdapter> void getBedInfo(final Recycler recycler, Class<T> adapterName) {

    BedInfoGetter.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
        @Override
        public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
            if (e != null) {
                return;
            }
            BedInfo.clear();
            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                Bed oneBedInfo = documentSnapshot.toObject(Bed.class);
                activeValue = documentSnapshot.getId();
                oneBedInfo.getId(activeValue);
                BedInfo.add(oneBedInfo);
            }
            T adapter = new BaseAdapter(info, context, activity);
            MainRecycler.setAdapter(adapter);
            MainRecycler.setItemAnimator(new DefaultItemAnimator());
        }
    });
}