Collections.sort(nameList, new Comparator<ListData.ListItem>()
{
    @Override
    public int compare(ListItem lhs, ListItem rhs)
    {
        return String.CASE_INSENSITIVE_ORDER.compare(lhs.nameDefinition.name, rhs.nameDefinition.name);
    }
});