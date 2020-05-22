@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    //loop data all user
    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

        //instance object to get and set data
        ModelDB modelDB = postSnapshot.getValue(ModelDB.class);

        //adding data list from object
        dbList.add(modelDB);
        adapter.notifyDataSetChanged();
    }

}