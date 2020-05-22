public boolean hasItemComponentPair(String itemName, String componentName)
{
    for(Item item : getItems())
    {
        if (item.getName().equals(itemName))
        {
            return item.getComponents().containsKey(componentName);
        }
    }

    return false;
}