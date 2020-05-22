public void encryptFile(String sourceFilePath, String destinationFilePath) {
    try {    
        try (Scanner reader = new Scanner(new File(sourceFilePath)); 
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {
            String line;
            while(reader.hasNextLine()) {
                line = reader.nextLine();
                String encryptedLine = easyEncrypt(line);
                writer.write(encryptedLine + System.lineSeparator());
            }
        }
    }
    catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }

}