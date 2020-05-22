ImageButton buttonToChange = (ImageButton) view.findViewById(R.id.pick_up_button);

if (buttonToChange.getTag(R.bool.PICKED_UP_TAG).toString() == "false") {
     buttonToChange.setImageResource(R.drawable.triangle_full);
     int myPosition = (Integer) buttonToChange.getTag(R.integer.LIST_ITEM_POSITION);
     ShoppingListItem itemToChange = shoppingListItems.get(myPosition);
     itemToChange.setPickedUp(true);
 }

 else if (buttonToChange.getTag(R.bool.PICKED_UP_TAG).toString() == "true") {
     buttonToChange.setImageResource(R.drawable.triangle_empty);
     int myPosition = (Integer) buttonToChange.getTag(R.integer.LIST_ITEM_POSITION);
     ShoppingListItem itemToChange = shoppingListItems.get(myPosition);
     itemToChange.setPickedUp(false);
 }

listAdapter.notifyDataSetChanged();