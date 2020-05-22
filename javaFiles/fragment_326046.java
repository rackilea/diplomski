ref2.addValueEvent(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    infoList.clear();

    for (DataSnapshot infoSnapshot : dataSnapshot.getChildren())
    {
        for (DataSnapshot infomationsnap : infoSnapshot.getChildren())
        {
            ReWalker rewalker = infomationsnap.getValue(ReWalker.class)
            infoList.add(rewalker);
        }
    }

});