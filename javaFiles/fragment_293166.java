Scanner in = new Scanner(/**source*/);

in.useDelimiter(":");

String firstName, lastName;

String firstWord = in.next();

Scanner nameScanner = new Scanner(in.nextLine());

nameScanner.useDelimiter(";");

firstName = getName(new Scanner(nameScanner.next()));

lastName = getName(new Scanner(nameScanner.next()));


private String getName(Scanner nameScanner){
    nameScanner.useDelimiter("=");

    String nameTitle = nameScanner.next();

    return nameScanner.next();
}