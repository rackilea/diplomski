public static PrintWriter openOutputTextFile(String fileName)
        throws FileNotFoundException {
    System.out.println( "Trying to create file: '" + fileName + "'" );
    PrintWriter toFile = new PrintWriter(fileName);
    return toFile;
}