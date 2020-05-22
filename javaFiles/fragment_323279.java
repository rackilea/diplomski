System.out.println("Enter file name: ");
Scanner fileNameScanner = new Scanner( System.in );
String fileName = "";

if ( fileNameScanner .hasNext() ) {
    fileName = fileNameScanner.next();
}
...