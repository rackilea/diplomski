public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    double tF = 0.0001;
    double tC = 0.0001;          
    int convertFer = 0;
    int convertCel = 1;

    System.out.println("Welcome to the Temperature Converter!\n"
            + "Enter 0 to convert F --> C and 1 to convert from C --> F.\n"
            + "Enter Control-Z when done!");

    convertFer = reader.nextInt();

    if (convertFer == 0) {
        System.out.println("Welcome to the F --> C Converter!\n" + "Enter Values to convert:");
        while (reader.hasNext()){ 

        tC = reader.nextDouble();

        tF = ((tC - 32) * 5) / 9;
           System.out.println(tC +" F = " + tF + " C");}

     } else {
        System.out.println("Welcome to the C --> F Converter!\n" + "Enter Values to convert:");
        while (reader.hasNext()){

        tF = reader.nextDouble();

        tC = ((tF * 9) / 5) + 32;
           System.out.println(tF + "C = " + tC + " F");}

        System.out.println("Goodbye!");
        System.exit(0);     
     }     
 }