//Either the class itself needs to implement Comparable<T>, or a similar
//Comparable instance needs to be passed into a TreeSet 
public class Widget implements Comparable<Widget>
{
    private final String name;
    private final int id;

    Widget(String n, int i)
    {
        name = n;
        id = i;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    //Something like this already exists in your class
    @Override
    public boolean equals(Object o)
    {
        if(o != null && (o instanceof Widget)) {
            return ((Widget)o).getName().equals(name) &&
                   ((Widget)o).getId() == id;
        }
        return false;
    }

    //This is required for HashSet
    //Note that if you override equals, you should override this
    //as well. See: http://stackoverflow.com/questions/27581/overriding-equals-and-hashcode-in-java
    @Override 
    public int hashCode()
    {
        return ((Integer)id).hashCode() + name.hashCode();
    }

    //This is required for TreeSet
    @Override
    public int compareTo(Widget w)
    {
        if(id < w.getId()) return -1;
        else if(id > w.getId()) return 1;
        return name.compareTo(w.getName());
    }

    @Override 
    public String toString()
    {
        return "Widget: " + name + ", id: " + id;
    }
}