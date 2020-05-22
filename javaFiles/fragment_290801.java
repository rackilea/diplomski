//FIRST OF ALL: Make sure "items" is not null
if(items != null && items.get(seed) != null){
  ItemDialog itemDialog = ItemDialog.class.getResource("/items/" + items.get(seed).getImage())
  if(itemDialog != null)
  lblNewLabel.setIcon(new ImageIcon(itemDialog));
}

/*I am not sure about of which type is the object items is carrying, but a more
decent approach would be*/

if(items != null){
  "ObjectThatItemsIsCarrying" obj = items.get(seed);
  //Checking if you got the image name
  if(obj != null) 
  ItemDialog itemDialog = ItemDialog.class.getResource("/items/" + obj.getImage());
  //Cheking if you got the image
  if(itemDialog != null)
  lblNewLabel.setIcon(new ImageIcon(itemDialog));
}