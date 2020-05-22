Map<Brand, ArrayList<Item>> map = new HashMap<Brand, ArrayList<Item>>();


for(Item item : purchaseOrderList){
  if(map.get(item.getBrand()) == null)
    map.put(item.getBrand(), new ArrayList<Item>());
  else 
    map.get(item.getBrand()).add(item);
}