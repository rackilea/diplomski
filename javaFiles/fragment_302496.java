public void test()
{
    Map myMap = new HashMap();
    String key;
    for(Iterator iterator = myMap.keySet().iterator(); iterator.hasNext(); System.out.println((String)myMap.get(key)))
    {
        key = (String)iterator.next();
        System.out.println(key);
    }

    Set keySet = myMap.keySet();
    String key;
    for(Iterator iterator1 = keySet.iterator(); iterator1.hasNext(); System.out.println((String)myMap.get(key)))
    {
        key = (String)iterator1.next();
        System.out.println(key);
    }
}