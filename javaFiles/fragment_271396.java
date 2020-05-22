public YourClass 
{
    public static List<YourClass> list = new ArrayList<>();
    public YourClass()
    {
        list.add(this);
    }
}