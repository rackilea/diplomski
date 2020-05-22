File file = new File(dir, repName+"_"+tdate+".PDF");
...
private static void checkFileExist(File file) {
    System.out.println("Filename: " + file);
    if (file.exists()) {
        System.out.println("Exist in location!");
    } else {
        System.out.println("Does not exist in location!");
    }
}