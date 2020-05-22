String loadSuperImportantFile() {
    try {
        return fileContent;
    } catch(IOException ex) {
        throw new ImportantFileMissingException("Failed to load super important file. Please check path.");
    }
}

class ImportantFileMissingException extends RuntimeException {}