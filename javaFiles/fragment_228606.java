// Create an item as usual
Item myItem = new Item();
myItem.setItemName("name");

// Add it to a parcel
Parcel parcel = Parcel.obtain();
parcel.writeValue(myItem);

// Read the item back from the parcel
parcel.setDataPosition(0);
Item newItem = (Item) parcel.readValue(Item.class.getClassLoader());

// When you are finished with the parcel
parcel.recycle();