public static int readFilename() {
    Scanner scan = new Scanner(System.in);
    String input;
    int average = 0;
    boolean flag= true;
    while(flag)
    {
    try{

        System.out.print("Enter a filename: ");
        input = scan.next();
        FileReader read = new FileReader(input);
        average = AverageFile.average(input);
         flag= false;

    }
    catch(FileNotFoundException e){
        System.out.println("Incorrect file input");


    }

    }
    return average;
    }