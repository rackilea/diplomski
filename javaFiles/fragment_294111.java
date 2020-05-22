for (Map.Entry<String, List<Attribute>> entry : binList.entrySet())
{
    System.out.println("Key: " + entry.getKey());

    // Each value is a List<Attribute>, so you can iterate though that as well
    for (Attribute a : entry.getValue())
    {
        // This assumes Attribute.toString() prints something useful 
        System.out.println("Attribute: " + a);
    }
}