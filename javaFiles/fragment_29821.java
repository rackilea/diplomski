public void setPlaylist (File folder) {
    songsList.clear();
    File[] musicFiles = folder.listFiles(new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            return (name.endsWith(".mp3") || name.endsWith(".m4a"));
        }
    });
    for (File file : musicFiles) {
        songsList.add(file.toURI());
    }
}