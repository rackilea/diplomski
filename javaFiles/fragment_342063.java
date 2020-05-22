(File file1, File file2) -> {
    if(file1.getName().equals("README.txt"))
         return 1;  //readme-file is always "greater" than other files
    if(file2.getName().equals("README.txt"))
         return -1;
    else 
        return file2.getName().compareToIgnoreCase(file1.getName()));
 };