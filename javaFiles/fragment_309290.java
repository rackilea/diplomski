//directories within assets that you want a catalog of
static final String[] directories = {
        "completeMaps",
        "typeAMaps",
        "typeBMaps",
        "sfx",
        "music"
};

public static void main (String[] args){
    String workingDir = System.getProperty("user.dir");
    for (String dir : directories){
        File directory = new File(workingDir + "/" + dir);
        File outputFile = new File(directory, "catalog.txt");
        FileUtils.deleteQuietly(outputFile); //delete previous catalog
        File[] files = directory.listFiles();
        try {
            for (int i = 0; i < files.length; i++) {
                FileUtils.write(outputFile, files[i].getName() + (i == files.length - 1 ? "" : "\n"), true);
            }
        } catch (IOException e){
            Util.logError(e);
        }
    }
}