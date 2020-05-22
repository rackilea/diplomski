Set<CharSequence> dataSet = new HashSet<CharSequence>(Arrays.asList("a","b"));
    Set<String> output = new HashSet<String>();

    for(CharSequence c : dataSet){
        output.add(c.toString());
    }