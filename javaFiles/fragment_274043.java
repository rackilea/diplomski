// Declare Scanner Object to read our file
    Scanner in = new Scanner(new File(stringRepresentingLocationOfYourFileHere));

    // create Map that will contain keys in sorted order (TreeMap)
    // along with last value assigned to the key
    Map<String, String> mapa = new TreeMap<>();

    // another map to hold keys from first map and number of
    // occurrences of those keys (repetitions), this could have been
    // done using single Map as well, but whatever
    Map<String, Integer> mapaDva = new HashMap<>();

    // String array that will hold words of each line of our .txt file
    String[] line;

    // we loop until we reach end of our .txt file
    while(in.hasNextLine()){

        // check if map already contains given key, if it does
        // increment value by 1 otherwise initialize the value with 1
        if (mapa.put((line = in.nextLine().split(" "))[0], line[1]) != null)
            mapaDva.put(line[0], mapaDva.get(line[0])+1);
        else
            mapaDva.put(line[0], 1);
    }

    // loop through our maps and print out keys, number of 
    //repetitions, last assigned value
    for (Map.Entry<String, String> m : mapa.entrySet()){
        System.out.println(m.getKey() + " " + mapaDva.get(m.getKey()) + " " + m.getValue());
    }