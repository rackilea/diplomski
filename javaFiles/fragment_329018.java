public static int[] processFile (String filename) throws IOException, FileNotFoundException{
    BufferedReader inputReader = new BufferedReader (new InputStreamReader(new FileInputStream(filename)));
    String line;

    int[] a = new int[25];

    int i = 0; // We need to maintain our own iterator when using a while loop

    while((line = inputReader.readLine()) != null){
        int intValue = Integer.parseInt(line); //converts string into int

        a[i] = intValue; // Store intValue into the array at index i

        i++; // Increment i
    }
    return a;
}