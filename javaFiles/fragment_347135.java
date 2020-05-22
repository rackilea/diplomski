databaseReference = FirebaseDatabase.getInstance().getReference("Order");
databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        orderList = new ArrayList<>();

        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
            for (DataSnapshot orderSnapshot : userSnapshot.getChildren()) {
                orderList.add(orderSnapshot.getValue(Order.class));
            }
        }

        psOrderAdapter PsOrderAdapter = new psOrderAdapter(orderList);
        recyclerView.setAdapter(PsOrderAdapter);
    }