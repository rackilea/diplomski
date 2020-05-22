// array of File objects that hold path to all your files to iterate through
    File[] files = {new File("file1.txt"),
                    new File("file2.txt"),
                    new File("file3.txt")};

    Scanner in;
    Map<String, String> mapa = new TreeMap<>();
    Map<String, Integer> mapaDva = new HashMap<>();
    String[] line;

    for (int i = 0; i < files.length; i++) {
        // assign new File to Scanner on each iteration (go through our File array)
        in = new Scanner(files[i]);
        while(in.hasNextLine()){
            if (mapa.put((line = in.nextLine().split(" "))[0], line[1]) != null)
                mapaDva.put(line[0], mapaDva.get(line[0])+1);
            else
                mapaDva.put(line[0], 1);
        }
    }



    for (Map.Entry<String, String> m : mapa.entrySet()){
        System.out.println(m.getKey() + " " + mapaDva.get(m.getKey()) + " " + m.getValue());
    }