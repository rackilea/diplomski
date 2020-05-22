FTPFiles[] downloadFiles = ftp.listFiles();
List<FTPFile> xlsFiles = new ArrayList<FTPFile>();
for(FTPFilei : downloadFiles) {
    if(i.getName().endsWith(".xls")) {
        xlsFiles.add(i);
    }
}