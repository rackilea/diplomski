//Create a grouped map using Collectors.groupingBy 
 Map m = itemslist.stream().collect(Collectors.groupingBy(ShipmentItemsModel::getLrid));
 //Make an ArrayList of keys
 ArrayList<Integer> keys = new ArrayList<>(m.keySet());
  //Use enhanced for loop (foreach) to go through each key in order to create list of items each key has.
  //(In Layman terms: It will create small lists based on keys)  
  for (int singlekey: keys) {
         ArrayList<ShipmentItemsModel> values = new ArrayList<ShipmentItemsModel>();
            values = (ArrayList<ShipmentItemsModel>) m.get(singlekey);
            for (ShipmentItemsModel sortedmodel: values) {
                System.out.println("Key/ID :"+singlekey+" and values :"+sortedmodel.getProductname());
            }
        }