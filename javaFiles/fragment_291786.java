Arrays.sort(array, new Comparator<Integer>()
{
    public int compare(Integer i1, Integer i2)
    {
        return -i1.compareTo(i2);
    }
});