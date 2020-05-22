interface IFilter
{
    List<Item> Filter(List<Item> items);
}

class FilterA implements IFilter
{
    public List<Item> Filter(List<Item> items)
    {
        //filter
    }
}

class FilterB implements IFilter
{
    public List<Item> Filter(List<Item> items)
    {
        //filter
    }
}

//list that would have filters added to it as the user activates filters
List<IFilter> filters = new List<IFilter>();    
//your list of items
List<Item> items = new List<Item>();

public List<Item> Filter() {
    for (IFilter filter : filters) {
        items = filter.Filter(items);
    }    
    return items;
}