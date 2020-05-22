public StringBuffer readFile(final File inputFile) {
    String tempLine; // variable declaration
    Logger log = Logger.getLogger("Error Message");
    final StringBuffer content = new StringBuffer();
    try (final FileReader fileReader = new FileReader(inputFile);
            final BufferedReader bufferedReader = new BufferedReader(fileReader)){        
        while((tempLine=bufferedReader.readLine())!=null) {
            content.append(tempLine);
            content.append(System.getProperty("line.separator"));
        }
    }
    catch(FileNotFoundException e) {
        log.log(Level.WARNING, "File not found", e);
    }
    catch (IOException e) {
        log.log(Level.WARNING, "Couldn't Read file", e);
    }
    return content;
}