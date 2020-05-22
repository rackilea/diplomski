String folderName = "."; // Give your folderName
File[] listFiles = new File(folderName).listFiles();

for (int i = 0; i < listFiles.length; i++) {

    if (listFiles[i].isFile()) {
        String fileName = listFiles[i].getName();
        if (fileName.startsWith("MyTextFile_")
                && fileName.endsWith(".txt")) {
            System.out.println("found file" + " " + fileName);
        }
    }
}