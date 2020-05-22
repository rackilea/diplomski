private ArrayList<Item> carriedItems;
  /**
 * this private helper method checks the ArrayList for the requested Item name.  If found, return the Item.  
 * If not found, return null.
 * @param the name of the item
 * @return the item object
 */ 
public Item cherForItem(String name){
    for(Item i: carriedItems)
        if(name.compareTo(i.getName())==0)
            return i;
    return null;
}