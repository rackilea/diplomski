Scanner scanner = new Scanner(System.in);
scanner.useDelimiter("[^\\w']+");
String separator;
Pattern rx = Pattern.compile(".I \\d");
while (scanner.hasNext()){
    separator = scanner.findInLine(rx);
    if (separator!= null) {
        int num = Integer.valueOf(separator.substring(3));
        System.out.println("Found: " + separator+", article number: "+num);
        scanner.nextLine();
        scanner.nextLine();
    }
    System.out.println(scanner.nextLine());
}
scanner.close();