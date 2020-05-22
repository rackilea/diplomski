String[] words = {"ace", "ace","boom", "crew", "dog", "eon"}; 
    Set<String> hs = new LinkedHashSet<String>(Arrays.asList(words));
    String[]  mywords=hs.toArray(new String[hs.size()]);
    for(int i=0;i<mywords.length;i++)
    {
        System.out.println("..."+mywords[i]);
    }