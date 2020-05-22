@Root
public static class Something {

    @Text 
    @ElementListUnion({
       @ElementList(entry="child1", type=Integer.class, inline=true),
       @ElementList(entry="child2", type=Boolean.class, inline=true)
    })
    public List<Object> values;
}