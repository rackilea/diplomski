Path parentPath = Paths.get(FILE_PATH);

for (Iterator<File> iterator = files.iterator(); iterator.hasNext();){     
    Path filePath = iterator.next().toPath();
    Path relativePath = parentPath.relativize(filePath);
    System.out.println("File = " + relativePath );  
}