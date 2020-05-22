private static String retrieveSelectedWorkspace() throws FileNotFoundException {
    InputStream in = Gui.class.getResourceAsStream("/resources/log.ascii");
    Scanner scanner = new Scanner(in);
    while(scanner.hasNextLine())            
        return scanner.nextLine().toString();
    return null;
}