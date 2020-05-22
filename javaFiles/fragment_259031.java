ArrayList<File> Songs = findSongs("/storage/sdcard1/Music");
Collections.sort(Songs, new Comparator<File>() {
    @Override
    public int compare(File file1, File file2) {
        return file1.getName().compareTo(file2.getName());
    }
});