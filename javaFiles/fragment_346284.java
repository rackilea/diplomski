public class Whatever 
{
    private List<String> children;

    public List<String> getChildren
    {
        if ( children == null ) { children = new ArrayList<String>(); }
        return children;
    }
    ...
}