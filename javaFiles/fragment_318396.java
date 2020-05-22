List<String> subDirectories = new ArrayList<>();
for (FileIdBothDirectoryInformation sub: subs) {
    String filename = sub.getFileName();
    if (".".equals(filename) || "..".equals(filename)) {
        continue;
    }
    if (EnumWithValue.EnumUtils.isSet(sub.getFileAttributes(), FileAttributes.FILE_ATTRIBUTE_DIRECTORY)) {
        subDirectories.add(filename);
    }
}