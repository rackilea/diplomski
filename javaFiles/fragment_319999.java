@Root(name = "RootNode")
@Convert(RootNodeConverter.class)   // <--- Important!
class RootNode
{
    private List<FooEntity> fooEntities;
    private List<BarEntity> barEntities;


    public RootNode()
    {
        // This has to be done somewhere ...
        this.fooEntities = new ArrayList<>();
        this.barEntities = new ArrayList<>();
    }


    public List<FooEntity> getFooEntities()
    {
        return fooEntities;
    }

    public List<BarEntity> getBarEntities()
    {
        return barEntities;
    }

    @Override
    public String toString()
    {
        return "RootNode{" + "fooEntities=" + fooEntities + ", barEntities=" + barEntities + '}';
    }
}