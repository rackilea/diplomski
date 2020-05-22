public void copyDifferentFolderFilesIntoOne(String mergedFolderStr,
        String... foldersStr) {
    final File mergedFolder = new File(mergedFolderStr);
    final Map<String, File> filesMap = new HashMap<String, File> ();
    for (String folder : foldersStr) {
        updateFilesMap(new File (folder), filesMap, null);
    }

    for (final Map.Entry<String, File> fileEntry : filesMap.entrySet()) {
        final String relativeName = fileEntry.getKey();
        final File srcFile = fileEntry.getValue();
        FileUtils.copyFile (srcFile, new File (mergedFolder, relativeName));
    }
}

private void updateFilesMap(final File baseFolder, final Map<String, File> filesMap,
        final String relativeName) {
    for (final File file : baseFolder.listFiles()) {
        final String fileRelativeName = getFileRelativeName (relativeName, file.getName());

        if (file.isDirectory()) {           
            updateFilesMap(file, filesMap, fileRelativeName);
        }
        else {
            final File existingFile = filesMap.get (fileRelativeName);
            if (existingFile == null || file.lastModified() > existingFile.lastModified() ) {
                filesMap.put (fileRelativeName, file);
            }
        }
    }
}

private String getFileRelativeName(final String baseName, final String fileName) {
    return baseName == null ? fileName : baseName + "/" + fileName;
}