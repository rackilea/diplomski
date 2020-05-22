Object[][] fileList = new Object[fileListVector.size()][2];

for (int i = 0; i < fileListVector.size(); i++) {
    fileList [i][0] = fileListVector.get(i).getFileName();
    fileList [i][1] = fileListVector.get(i).getFileSize();
}