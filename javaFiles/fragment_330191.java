public void print(int level)
{
    // print own name
    String branch = "|";
    for (int i = 0; i < level; i++)
    {
        branch += "-";
    }
    System.out.println(branch + name);

    // print names from list
    if (myObjectsList != null)
    {
        for (MyObject m : myObjectsList)
        {
            m.print(level+1);
        }
    }
}