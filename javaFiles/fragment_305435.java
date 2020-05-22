public static void main(String[] args) {
    String pathStringToAFile = "U:\\temp\\TestOutput\\TestFolder\\test_file.txt";
    String pathStringToAFolder = "U:\\temp\\TestOutput\\TestFolder";
    String pathStringToAFolderWithTrailingBackslash = "U:\\temp\\TestOutput\\TestFolder\\";

    Path pathToAFile = Paths.get(pathStringToAFile);
    Path pathToAFolder = Paths.get(pathStringToAFolder);
    Path pathToAFolderWithTrailingBackslash 
                        = Paths.get(pathStringToAFolderWithTrailingBackslash);

    System.out.println(pathToAFile.getFileName().toString());
    System.out.println(pathToAFolder.getFileName().toString());
    System.out.println(pathToAFolderWithTrailingBackslash.getFileName().toString());
}