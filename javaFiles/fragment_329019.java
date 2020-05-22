public static int[] processFile (String filename) throws IOException, FileNotFoundException{
    BufferedReader inputReader = new BufferedReader (new InputStreamReader(new FileInputStream(filename)));
    String line;

    int[] a = new int[25];

    for(int i = 0; i < a.length; i++){
        String line = inputReader.readLine(); // Move the readline code inside the loop

        if(line == null){
            // We hit EOF before we read 25 numbers, deal appropriately
        }else{
            a[i] = Integer.parseInt(line); 
        }
    }

    return a;
}