public static void main(String[] args) {
    // create a FileFilter 
    FileFilter ff = new FileFilter();
    // ask for extension
    System.out.println("Enter file name: ");
    Scanner scanner = new Scanner(System.in);
    String filename= scanner.nextLine();
    // use finder method to get array of Files
    File[] files = ff.finder(yourFolder, filename);
    // if files is empty
    if (files == null || files.length == 0) {
          // throw the error
    } else {
        // iterate over all found files:
        for (File f : files) {
            // f is pointing to excel file
        }
    }
}