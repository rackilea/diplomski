public static List<File> listOfFilesToMerge(String oneOfFiles) {
    return listOfFilesToMerge(new File(oneOfFiles));
}

public static void mergeFiles(String oneOfFiles, String into) throws IOException{
    mergeFiles(new File(oneOfFiles), new File(into));
}