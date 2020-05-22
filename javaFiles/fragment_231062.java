String inputKey = dataSource.next();
double val = dataSource.nextDouble();
List<Double> list = categoryMap.get(inputKey);

if (list == null)                    // If the key does not exist
{
    list  = new ArrayList<>();       // create a new list
    list.add(val);                   // with the given double
    categoryMap.put(inputKey, list); // and use it as the value
}
else                                 // Else
{
    list.add(val)                    // (got the list already) add the double to it
}