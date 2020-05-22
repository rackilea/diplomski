deleteFromCartButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    // TODO Auto-generated method stub

                    // To get the item from the listView for which the Add to Cart button is pressed
                    Item item = (Item)view.getTag();

                    // Delete the item from the cart by pressing the delete item button
                    DatabaseHelper db = new DatabaseHelper(getContext());
                    db.deleteItemFromCart(item.getID());

                    // Remove item
                    remove(item);

                    // Update the listView to reflect the changes
                    notifyDataSetChanged();
                }
}
deleteFromCartButton.setTag(getItem(position));