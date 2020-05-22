File myDir = new File(storage.getUploadDir());
File[] myFiles = myDir.listFiles();

if (myFiles != null) {
    for (File cFile : myFiles) {
        helper.addAttachment(cFile.getName(), cFile);
    }
}