public static void processName (String line) {
    Scanner scn = new Scanner(line);
    scn.useDelimiter(","); //declare it here
    ArrayList<String> name = new ArrayList<String>();  
    while ( scn.hasNext() ) {
        line = scn.next();
        name.add(line);
    }

    Collections.sort(name);

    for ( String nam : name ) {

        System.out.println(nam);
    }
}