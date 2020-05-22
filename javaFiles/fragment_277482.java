public static List<File> listOfFilesToMerge(File oneOfFiles) {
    String tmpName = oneOfFiles.getName();//{name}.{number}
    String destFileName = tmpName.substring(0, tmpName.lastIndexOf('.'));//remove .{number}
    File[] files = oneOfFiles.getParentFile().listFiles(
            (File dir, String name) -> name.matches(destFileName + "[.]\\d+"));
    Arrays.sort(files);//ensuring order 001, 002, ..., 010, ...
    return Arrays.asList(files);
}