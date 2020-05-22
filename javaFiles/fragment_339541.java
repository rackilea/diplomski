public static void Results() throws FileNotFoundException {
        //System.out.print("Input file name? ");
        Scanner input = new Scanner(new File("dna.txt"));
        //System.out.print("Output file name: ");
        File outputFile = new File("hi.txt");
        //System.out.println();

        PrintStream outputRead = new PrintStream(outputFile);
        String isProtein = "NO";
        while (input.hasNextLine()) {
            String line = input.nextLine().toUpperCase();
            //Scanner lineScan = new Scanner(line);
            //while (lineScan.hasNext()) {
                if (line.startsWith("ATG")) {
                    if (line.endsWith("TAA") || line.endsWith("TAG") || line.endsWith("TGA")) {
                        isProtein = "YES";
                   }
                }else{
                      isProtein = "NO";
                }
            //}
            outputRead.println(isProtein);
            isProtein = "NO";
        }
        //System.out.println(isProtein);
    }