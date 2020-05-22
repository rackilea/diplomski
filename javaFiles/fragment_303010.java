private String getGroupKey(String name)
{
        //Just comment that block so you can get full class names instead of package only
        /*
        int n = name.lastIndexOf('/');
        if (n > -1)
        {
            name = name.substring(0, n);
        }
       */
        // Replace resource char with package separator char        
        packages.add(name.replace("/", "."));
        //packages.add(name);
        return name;
}