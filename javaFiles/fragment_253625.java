Map<Object, Item> items = new HashMap<Object, Item>(); 

if (resultSet.next()) 
{
  Item root = createItem(resultSet);
  items.put(root.getId(), root);

  while (resultSet.next()) 
  {
    Item item = createItem(resultSet);
    items.put(item.getId(), item);

    Item parent = items.get(item.getParentId()); 
    if (parent != null) 
    {
      parent.addChild(item);
    }
    else
    {
      ...
    }
  }

  return root;
}
else 
{
  ...
}