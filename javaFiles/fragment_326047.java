ref2.addValueEvent(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    infoList.clear();

    for (DataSnapshot infoSnapshot : dataSnapshot.getChildren())
    {
        ReWalker rewalker = infoSnapshot.getValue(ReWalker.class)
        infoList.add(rewalker);
    }

});