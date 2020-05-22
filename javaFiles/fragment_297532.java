public static Long getFileSize(File dirDirectory) {
    return getFileSize(File dirDirectory, new HashSet<File>());
}

private static Long getFileSize(File dirDirectory, HashSet<File> prevProcess) {
    Long lngSize = new Long(0);

    for (File filItem : dirDirectory.listFiles()) {
        if (prevProcess.contains(filItem) continue;
        if (filItem.isDirectory()) {
            lngSize += getFileSize(filItem);
        }
        else {
            lngSize += filItem.length();
        }
        prevProcess.add(filItem);
    }

    return lngSize;
}