String path = System.getProperty("user.home") + File.separator + "Documents";
path += File.separator + "Your Custom Folder"
File customDir = new File(path);

if (customDir.exists()) {
    System.out.println(customDir + " already exists");
} else if (customDir.mkdirs()) {
    System.out.println(customDir + " was created");
} else {
    System.out.println(customDir + " was not created");
}