if (holder.getLayoutPosition() < listOfItems.length) {
    listOfItems[holder.getLayoutPosition()];
}
else {
    Log.d("TAG", "Error: index out of bounds");
}