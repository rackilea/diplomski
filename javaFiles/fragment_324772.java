ArrayList<String> array1 = new ArrayList<String>();
Map<String, List<String>> mapForYear = new TreeMap<String, List<String>>();
for(String date : array1)
{
    String year = date.substring(0,4);
    if(!mapForYear.containsKey(year))
        mapForYear.put(year, new ArrayList<String>());
    mapForYear.get(year).add(date);
}