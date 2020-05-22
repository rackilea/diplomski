File folder = new File("/Users/you/folder/");
File[] listOfFiles = folder.listFiles();
List<String> filteredList = new ArrayList<String>();

for (File file : listOfFiles) {
    // Be aware that folder.listFiles() give list with directories and files
    if (file.isFile()) {
        System.out.println(file.getName());

        // apply your filter. for simplicity I am equating the file names
        // name refers to input variable to method
        if(file.getName().toLowerCase().contains(name.toLowerCase())) { 
            // create user object and add it to list. 
            // Change below line with appropriate constructor params
            filteredList.add(file.getName())
        }
    }
}