public class CopyCollection {

    private List<Item> list = new ArrayList();

    public void add(Item item)
    {
        Item newItem = new Item();
        newItem.Name = item.Name;
        newItem.Price = item.Price;
        newItem.Des = item.Des;
        newItem.image = item.image;

        list.add(newItem);
    }

    public Item get(int index)
    {
        return list.get(index);
    }

    public int size()
    {
        return list.size();
    }   
}