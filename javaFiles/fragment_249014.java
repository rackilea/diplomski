List<Item> search(final String searchFor)
{
    List<Item> searchResults = new ArrayList<>();
    for(int i = 0; i<list.size(); i++)
    {
        Item item = list.get(i);
        if(item.description.contains(searchFor) ||
             item.category.contains(searchFor) ||
                String.valueOf(item.prize).contains(searchFor) )
       {searchResults.add(item);}
    }
    return searchResults;
}