public void drop(String name)
{      
    for (int i = 0; i < myArray.size(); i++) {
        Item count = myArray.get(i);
        if (count.getName().contains(name) && !currentRoom.hasItem()){
            currentRoom.addItem(count);
            currentMessage = "you have successfully dropped the item in the room";
            myArray.remove(count);
            i--; // element removed, so decrease count
        }
        else if(count.getName().contains(name) && currentRoom.hasItem() == true)
        {
            currentMessage = "the room already has an item";
        }
        else 
        {
            currentMessage = "you do not have that item";
        }
    }
}