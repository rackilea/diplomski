reference.addValueEventListener( new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        CBSList.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

            CBSList.add(snapshot.getKey());
        }

        String array[] = new String[CBSList.size()];

        for(int j =0;j<CBSList.size();j++){
            array[j] = CBSList.get(j);
        }

        if (CBSList.size() > 1) {
            numberPicker.setMaxValue(CBSList.size() - 1);
            numberPicker.setMinValue(0);
            numberPicker.setDisplayedValues(array);
            numberPicker.setWrapSelectorWheel(true);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
} );