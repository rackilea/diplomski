private FileHandle[] readDirectoryCatalogue (String directory){
    String[] fileNames = Gdx.files.internal(directory + "/catalog.txt").readString().split("\n");
    FileHandle[] files = new FileHandle[fileNames.length];
    for (int i = 0; i < fileNames.length; i++) {
        files[i] = Gdx.files.internal(directory + "/" + fileNames[i].replaceAll("\\s+",""));
    }
    return files;
}