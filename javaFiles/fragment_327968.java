File folder = new File("E:\\folder_to_LIST_OF_FILES");
File[] listOfFiles = folder.listFiles();

for (int i = 0; i < listOfFiles.length; i++) {
    if (listOfFiles[i].isFile()) {
        FilesDto returnDto = new FilesDto();
        returnDto.setFileName(FilenameUtils.removeExtension(listOfFiles[i].getName()));

        File file = new File("filename");
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        FileLock lock;
        try {
            lock = channel.tryLock();
        } catch (OverlappingFileLockException e) {
            // File is already locked 
        }

        if (lock==null) {
            returnDto.setStatus("unlocked");
            returnDto.setFilePath(listOfFiles[i].getAbsolutePath());

        } else {
            lock.release();
            returnDto.setStatus("Locked");
        }

        returnDtoList.add(returnDto);
    }
}