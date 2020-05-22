protected Map<String, Map<Priority, Order>> _buyBook = 
    new HashMap<String,Map<Priority,Order>>();
public void init() 
{
    _buyBook.put("key1", _buy);
    // or
    _buyBook.put("key1", new TreeMap<Priority, Order>(priorityCompare));
}