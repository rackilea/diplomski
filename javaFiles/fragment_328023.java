public List<File> getFiles(ProgressListener listener) {
    Iterator it = dirFiles.entrySet().iterator();
    int count = dirFiles.size();
    for (Map.Entry<String, ArrayList<String>> entry : dirFiles.entrySet()){
        count += entry.getValue() == null ? 0 : entry.getValue().size();
    }
    int index = 0;
    listener.setStatus("Processing files...");
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry) it.next();
        String folderName = (pair.getKey()).toString();
        ArrayList<String> FileNames = (ArrayList<String>) pair.getValue();
        if (FileNames != null) {
            for (String fileName : FileNames) {
                if (replaceSelected(fileName)) {
                    File fXmlFile = new File(fileName);
                    files.add(fXmlFile);
                } else {
                }
                index++;
                listener.progressChanged(index / (double)count);
            }
        }
    }
    return files;
}