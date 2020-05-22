List<Item> items = new ArrayList<Item>();

for(int i = 0; i < itemArray.length(); i++)
{
    Item item = new Item();
    item.name = itemArray.getJSONObject(i).getString("name");
    item.price = new BigDecimal(itemArray.getJSONObject(i).getString("baseprice"));
    items.add(item);
}