class VMFParser
{
    private String rawfile = "";

    // this is really the container for everything - think of it as the file shell
    private VMFClass root = new VMFClass("root", null, null);

    // construct yourself with the file
    public VMFParser (String fileName)
    {
        this.rawfile = fileName;
    }

    public void parse ()
    {
        // all the parsing code goes here
        read();
        evaluate();
        get();

        // now at this point your hierarchy is built and stored in the   
        // root object in this class.

        // Use the traverse method to go through it
    }

    private void get() throws VMFParsingException
    {
        // keep a reference to the current VMFClass parent
        // starts out as root
        VMFClass currParentClass = root;

        // main parse loop
        for (...)
        {
            // if you find a class
            VMFClass currClass = new VMFClass(/* params here */);

            // add this class to the parent
            currParentClass.add(currClass);

            // set the parent of this class
            currClass.setParent(currParentClass);

            // if you find a property
            // parse and add all the properties to the property
            VMFProperty property = new VMFProperty (/* value params here */);

            // attach this property to the last VMF class that got parsed
            currClass.setPoperties(property);

            // If you nest deeper into classes, then the parent becomes the current class
            currParentClass = currClass;

            // If you go back out of a class
            currParentClass = currClass.getParent();
        }
    }

    // Traverse the hierarchy
    public void traverse ()
    {
        traverseTree(root);
    }

    private void traverseTree (VMFClass root)
    {
        System.out.println("Class Name: " + root.getName());

        // print out any properties
        VMFProperty prop = root.getProperty();

        if (prop != null)
        {
            System.out.println("Property Name: " + prop.getName());

            String [] props = prop.getValues();
            for (String s: props)
            {
                System.out.println("Value: " + s);
            }
        }

        // get all child classes
        List<VMFClass> children = root.getChildren();
        for (VMFClass c: children)
        {
            traverseTree(c);
        }   
    }
}