public class VMFClass
{
    // name of the class
    private String name;

    // reference back up to the parent
    private VMFClass parentClass = null;

    // all direct children go here
    private List<VMFClass> children = new ArrayList<VMFClass>(); 

    // I don't think you need a list of properties here since your VMFProperty class holds onto an array of properties
    private VMFProperty properties;

    // set the parent of this class
    public void setParent (VMFClass parent)
    {
        this.parentClass = parent;
    }

    // get the direct children
    public List<VMFClass> getChildren()
    {
        return this.children;
    }

    // rest of methods...
}