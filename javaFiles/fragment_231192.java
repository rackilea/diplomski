Collections.sort(data, new Comparator<String[]>()
{
    @Override
    public int compare(String[] o1, String[] o2)
    {
        return o2[1].compareTo(o1[1]);
        // return -o1[1].compareTo(o2[1]);
    }
});