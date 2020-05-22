public void decryptFile(String sourceFilePath, String destinationFilePath) {
    try {    
        try (Scanner reader = new Scanner(new File(sourceFilePath)); 
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {
            String line;
            while(reader.hasNextLine()) {
                line = reader.nextLine();
                String decryptedLine = easyDecrypt(line);
                writer.write(decryptedLine + System.lineSeparator());
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