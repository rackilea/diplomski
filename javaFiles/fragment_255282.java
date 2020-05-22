class UnstructuredFile {
    private List<String> rawLines;

    public UnstructuredFile (List<String> rawLines) {
        this.rawLines = rawLines;
    }

    public List<FileRecord> readAllRecords() {
        //determine where start and stop one record in list list.sublist(0,5) or split it to List<List<String>>

    }

    private FileRecord readOneRecord(List<String> record) {
        //read one record from list
    } 

}