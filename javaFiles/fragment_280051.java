Path path = Paths.get("/test/outputXXXX.txt");
    ArrayList<Object> mainlist= new ArrayList<>();
    LinkedHashMap<String, String> hmap = new LinkedHashMap<>();
    for (int i=0;i<5;i++)
    {
        hmap.put("key1", "03-08-2018");
        hmap.put("key2", "xyz");
        hmap.put("key3", "123");
        //ArrayList USed:::
        mainlist.add(hmap);
        mainlist.add("\n");
    }
    try (BufferedWriter writer = Files.newBufferedWriter(path))
    {
        writer.write(mainlist.toString());
    }