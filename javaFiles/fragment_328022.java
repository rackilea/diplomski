private void convertToXLS(FileManager fileMgr, ProgressListener listener) {
    try {
        int i = 1;
        listener.progressChanged(0d);
        List<File> files = fileMgr.getFiles(listener);
        for (File file : files) {
            listener.setStatus("Reading " + i + " of " + fileMgr.getSize() + " files");
            parUtils.parseFileUsingDOM(file); // This will read content of the input file 
            listener.progressChanged(i / (double) files.size());
        }
        btnConvertXmlTo.setEnabled(true);

    } catch (Exception e) {
        e.printStackTrace();
    }
}