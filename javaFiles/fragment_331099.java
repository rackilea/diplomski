final Map<String, Integer> monthMap = new LinkedHashMap<String, Integer>();
// Initialize it with all the months and corresponding index like:
// (January,1), (February,2), etc...
monthMap.put("January", 1);
monthMap.put("February", 2);
monthMap.put("March", 3);
monthMap.put("April", 4);
monthMap.put("May", 5);
monthMap.put("June", 6);
monthMap.put("July", 7);
monthMap.put("August", 8);
monthMap.put("September", 9);
monthMap.put("October", 10);
monthMap.put("November", 11);
monthMap.put("December", 12);

Collections.sort(list, new Comparator<String>()
{
    @Override
    public int compare(String a, String b)
    {
        String first = a.substring(0, a.indexOf(File.separatorChar));
        String second = b.substring(0, b.indexOf(File.separatorChar));

        return monthMap.get(first).compareTo(monthMap.get(second));
    }
});