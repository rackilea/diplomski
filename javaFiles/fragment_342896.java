for (DataSnapshot d : dataSnapshot.getChildren()) {
    OrderedItem orderedItem = d.getValue(OrderedItem.class);
    Log.d(TAG, "orderedItem:" + orderedItem.getUserName());
    items.putIfAbsent(d.getKey(), new ArrayList<>());//create a list if it doesn't exist
    items.get(d.geyKey()).add(orderedItem);//add the item

}