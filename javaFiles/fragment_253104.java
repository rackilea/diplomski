class Person implements Map
{
    private HashMap<String, Object> myMap;
    private String name;
    public Object get(Object key)
    {
        switch(key) {
            case "name": return getName();
            default: myMap.get(key)
        }
    }
    public String getName()
    {
        return this.name;
    }
}