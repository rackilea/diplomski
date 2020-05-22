Set<String> set = new LinkedHashSet<String>();
    for(int i = 0; i <5; i++)
    {
        set.add( i+"" );
    }
    // insertion order is 0,1,2,3,4
    for(String str : set)
    {
        System.out.println(str);
    }

    //output 0,1,2,3,4