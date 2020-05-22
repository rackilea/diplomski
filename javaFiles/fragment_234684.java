private void getAllAudioFilePath(String rootFolder) {
    File file = new File(rootFolder);
    if (file.isDirectory()) {
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    loadAllImages(f.getAbsolutePath());
                } else {
                    for (int i = 0; i < extensions.length; i++) {
                        if (f.getAbsolutePath().endsWith(extensions[i])) {
                            Log.i("Song files paths....",""+f.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

}