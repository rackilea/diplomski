private static String loadXml(String filePath) {
    try {
        StringBuilder xml = new StringBuilder();
        Scanner scanner = new Scanner(new File(filePath)); // i.e. C:\\testXML.xml

        while (scanner.hasNextLine()) {
            xml.append(scanner.nextLine());
        }
        return xml.toString();
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return null;
}