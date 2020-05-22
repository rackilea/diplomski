List<String> index = new ArrayList<String>();
    index.add("This");
    index.add("test");
    String x = "This is a random test phrase";
    for (String s : index)
    {
        x = x.replaceAll(s, "*");
    }
    System.out.println(x);