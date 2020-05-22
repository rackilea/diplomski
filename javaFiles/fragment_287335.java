public void removeItem(String description)
{
    Iterator<Item> i = items.iterator();

    while (i.hasNext())
    {
        Item items = i.next();

        if (items.getDescription().equals(description))
        {
            i.remove();
            System.out.print("Item removed!");
            return;
        }
    }
}