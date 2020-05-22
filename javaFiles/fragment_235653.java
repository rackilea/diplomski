public List<String> descending()
{
    List<String> x = new ArrayList<String>(10);
    Collections.sort(oneName, new OneNameCountCompare());
    for(OneName b: oneName)
    {
        x.add(b.toString());
        if (x.size() == 10) // Or don't use enhanced for, use an index instead
        {
            break;
        }
    }
    return x;
}