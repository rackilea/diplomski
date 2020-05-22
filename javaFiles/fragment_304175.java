File dir = new File(homeDir + "/Desktop/DFiles";
for (File f : dir.listFiles()) {
    if (f.isDirectory()) {
        System.out.println("Found subdirectory: " + f.getName());
    } else {
        System.out.println("Found file: " + f.getName());
    }
}