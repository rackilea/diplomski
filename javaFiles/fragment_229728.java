public void writeListToFile(List<String> strings, boolean addNewLine) throws Exception {
    strings.stream().forEach(s -> {
        try {
            writeStringToFile(s, addNewLine);
        } catch (IOException ex) {
            //you can Log it immediately or throw ex;
            Logger.getLogger(C.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    // Unhandled IOException from writeStringToFile
}