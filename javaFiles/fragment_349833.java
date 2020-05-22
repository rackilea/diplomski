if (!NETWORK_FILE.exists()) {
   ...
}

else {
    Scanner read = createScannerWithExistingFile(NETWORK_FILE);
    while (read.hasNextLine()) {
        String fileSerial = read.nextLine();
        if (fileSerial.equals(serial)) {
            System.out.println("serial already exists");
            return;
        }
    }
    read.close();

}

private Scanner createScannerWithExistingFile(File file) {
    try {
        return new Scanner(file);
    } catch (FileNotFoundException e) {     
        throw new RuntimeException("file " + f + " should exist", e);
    }
}