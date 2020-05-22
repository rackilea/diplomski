public String FilesInFolder() throws IOException {
    FileWriter fw = new FileWriter("file.txt");
    StringWriter sw = new StringWriter();

    // Will list all files in the directory, want to create a feature on the page that can display this to the user

    String path = NewDestination;
    System.out.println("Starting searching files in directory"); // making sure it is called
    String files;
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {

        if (listOfFiles[i].isFile()) {
            files = listOfFiles[i].getName();
            sw.write(files);
            System.out.println(files);
        }
    }
    fw.write(sw.toString());
    fw.close();
    return "";
}