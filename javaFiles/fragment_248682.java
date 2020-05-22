myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            accountSetBudgetHelper = ds.getValue(AccountSetBudgetHelper.class);
            dept.add(accountSetBudgetHelper.getName());
            total.add(accountSetBudgetHelper.getTotal());
        }
        accountSetBudgetAdapter.notifyDataSetChanged(); //Notify the adapter
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
});