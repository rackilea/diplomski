public static void processLine(File input, File output) throws FileNotFoundException{ 
    Scanner i = new Scanner(input);
    PrintStream o = new PrintStream(output);

    ArrayList<String> saved= new ArrayList<String>();

    while(i.hasNextLine()){
        String text = i.nextLine();                 
        saved.add(text);
    }


    // you can use "saved" here ! :) enjoy
}