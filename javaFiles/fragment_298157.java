class DependencyStack
{
    // A Map provides quick lookup
    private final Map<String, DependencyDataCollection> dependencies;

    // a LinkedHashMap allows for quick lookup, but iterates in the order they were added... if that matters for show.
    {
        dependencies = new LinkedHashMap<String, DependencyDataCollection>();
    }

    // your Stack shouldn't know how to make the collections... (in my opinion)
    public void add(final DependencyDataCollection ddc)
    {
        if(ddc == null)
        {
            throw new IllegalArgumentException("ddc cannot be null");
        }

        dependencies.put(ddc.getSessionID(), ddc);
    }

    public int size()
    {
        return dependencies.size();
    }

    // the next 3 methods are just convenience since you don't know if someione
    // will want to write to a file or a writer instead of a stream
    public void show()
    {
        show(System.out);
    }

    public void show(final OutputStream out)
    {
        show(new OutputStreamWriter(out));
    }

    public void show(final Writer writer)
    {
        show(new PrintWriter(writer));
    }

    public void show(final PrintWriter writer)
    {
        // use the new for-each instead of the old style for loop
        // this also uses an iterator which is faster than calling get
        // (well on an ArrayList it probably is about the same, but a LinkedList it'll be faster)
        for(final DependencyDataCollection ddc : dependencies.values())
        {
            writer.println(ddc.getSNo()            + "   " +
                           ddc.getSessionID()      + "   " +
                           ddc.getNoOfDependency() + "   " +
                           ddc.getNoOfRejection()  + "   " +
                           ddc.getTotalValue());
        }
    }

    public int returnIndexOfSession(final String sessionID)
    {
        final DependencyDataCollection ddc;
        final int                      retVal;

        if(sessionID == null)
        {
            throw new IllegalArgumentException("sessionID cannot be null");
        }

        // get it if it exists, this is much faster then looping through a list
        ddc = dependencies.get(sessionID);

        // deal with the fact that you might have not found the item and it would be null.
        // this assumes -1 is an invalid session id
        if(ddc == null)
        {
            retVal = -1;
        }
        else
        {
            retVal = ddc.getSNo();
        }

        return (retVal);
    }

    public static void main(final String[] args)
    {
        DependencyStack ds = new DependencyStack();
        ds.add(new DependencyDataCollection(1,"a",0,0,0));
        ds.add(new DependencyDataCollection(1,"a",0,0,0));
        ds.show();

        //System.out.println(ds.returnIndexOfSession("a"));

//        DependencyDataCollection ddc = new DependencyDataCollection(1,"a",0,0,0);
//        System.out.println(ds.indexOf(ddc));
    }
}