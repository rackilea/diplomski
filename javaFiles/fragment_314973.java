public ArrayList<HashMap<String, String>> getPlayList() {
        System.out.println(MEDIA_PATH);
        if (MEDIA_PATH != null) {
            File home = new File(MEDIA_PATH);
            File[] listFiles = home.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                ArrayList<File> temp = new ArrayList<>();
                for (File file : listFiles) {
                    System.out.println(file.getAbsolutePath());
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else {
                        temp.add(file);

                    }
                }
                Collections.sort(temp, new Comparator<File>() {

                    @Override
                    public int compare(File o1, File o2) {
                        // TODO Auto-generated method stub
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                addSongToList(temp);
            }
        }
        // return songs list array
        return songsList;
    }

    private void scanDirectory(File directory) {
        if (directory != null) {
            File[] listFiles = directory.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                ArrayList<File> temp = new ArrayList<>();
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else {
                        temp.add(file);
                    }

                }
                Collections.sort(temp, new Comparator<File>() {

                    @Override
                    public int compare(File o1, File o2) {
                        // TODO Auto-generated method stub
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                addSongToList(temp);
            }
        }
    }


    private void addSongToList(ArrayList<File> temp) {
        for(int i = 0; i<temp.size(); i++)
        {
        if (temp.get(i).getName().endsWith(mp3Pattern)) {
            HashMap<String, String> songMap = new HashMap<String, String>();
            songMap.put("songTitle",
                    temp.get(i).getName().substring(0, (temp.get(i).getName().length() - 4)));
            songMap.put("songPath", temp.get(i).getPath());

            // Adding each song to SongList
            songsList.add(songMap);
        }
        }
    }
}