[...]
if (sourceLocation.isDirectory()) {
    String[] children = sourceLocation.list();
    // List to save the name of the files you want to copy
    List<String> foundFiles = new ArrayList<String>(array.size()); 
    for(String element : children){
        if (array.contains(element)){
            // If the file you want to copy are in the sourceDiretory 
            // add its name to the list
            foundFiles.add(element); 
            targetLocation.mkdirs();   
        }
    }    
    for (String foundFile : foundFiles) {
         copyDirectory(new File(sourceLocation, foundFile),
                    new File(targetLocation, foundFile), array);
    }
}
[...]