public static void processName (String line) {
    ArrayList<String> name = new ArrayList<String>();
    //splits the string around commas
    String[] inputs = line.split(",");
    //now take all the names/values that were seperated by the comma and add them to your list
    for(int i = 0; i < inputs.length; i++)
    {
        name.add(inputs[i]);
    }
    //sort the list once
    Collections.sort(name);
    //output the names/values in sorted order
    for ( String nam : name ) {

        System.out.println(nam);
    }
}