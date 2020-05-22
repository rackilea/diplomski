Iterator<Map.Entry<String, List<Attribute>>> it = binList.entrySet().iterator();
while (it.hasNext())
{
    Map.Entry<String, List<Attribute>> entry = it.next();
    System.out.println("Key: " + entry.getKey());

    // Each value is a List<Attribute>, so you can iterate though that as well
    Iterator<Attribute> it2 = entry.getValue().iterator();

    while (it2.hasNext())
    {
        Attribute a = it2.next();
        // This assumes Attribute.toString() prints something useful 
        System.out.println("Attribute: " + a);
    }
}