for (File f1 : filesList1)
{
    if(f1.isFile())
    {
        for (File f2 : filesList2) 
        {
            if(f2.isFile() && f1.getName().equals(f2.getName))
            {
                commonfiles.add(f1.getName());
                System.out.println(f1.getName());
            }
        }
    }
}