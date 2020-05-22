for (String cpElement : System.getProperty("java.class.path").split(File.pathSeparator)) {
    File cpFile = new File(cpElement);
    if (!cpFile.exists()) {
         continue;
    }
    if (cpFile.isDirectory()) {
        findClassesInDirectory(cpFile);
    } else {
        findClassesInArchive(cpFile); 
    }
}