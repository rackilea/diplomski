FileReader input = new FileReader(filePathToYourFile);
BufferedReader bufRead = new BufferedReader(input);
String readLine = null;
String shp = "SHP"; //or define them as "constants" with static final
String item = "ITEM";
String data = "DATA";
ArrayList<SHPType> listOfSHPObjects = new ArrayList<SHPType>();
SHPType lastSHP;
ItemType lastItem;

while ( (readLine = bufRead.readLine()) != null)
{    
    String[] splittedLine = readLine.split(" ");
    if(splittedLine[0].equals(shp))
    { //if it's an SHP, make an SHP object, and add it to a list.
        lastSHP = new SHPType();
        listOfSHPObjects.add(lastshp);
    }
    if(splittedLine[0].equals(data) && lastSHP != null)
    { //if it's a data object, either add it to the property/field/list/collection of the latest SHP, or if you have found an item, add it to the item.
      //of course if you haven't found any SHP objects, discard it, as it doesn't belong anywhere
        if(lastItem == null)
           lastSHP.CollectionThatHoldsData.add(new DataType());
        else
           lastItem.CollectionThatHoldsData.add(new DataType());
    }
    if(splittedLine[0].equals(item) && lastSHP != null)
    {
        //create a new last item and add it to the item list of the last SHP found. New data will be added to this item
        lastItem = new ItemType();
        lastSHP.CollectionThatHoldsItems.add(lastItem);
    }
}
//close the file etc...