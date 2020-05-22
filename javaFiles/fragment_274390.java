private void updatePlaylist() {
    // TODO Auto-generated method stub
    File home = new File(SD_PATH);
    if(home.listFiles( new Mp3Filter()).length > 0){
        for(File file : home.listFiles( new Mp3Filter())) {
            songs.add(file.getName());
            songsPaths.add(file.getAbsolutePath());
        }
        ArrayAdapter<String> songList = new ArrayAdapter<String>(this,R.layout.song_items,songs);
        setListAdapter(songList);
    }
}

@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);
    try{
        mp.reset();
        mp.setDataSource(songsPaths.get(position));
        mp.prepare();
        mp.start();
        if(mp.isPlaying()== true){
            play.setText("Pause");
            play.setVisibility(View.VISIBLE);
        }

    } catch(IOException e){
        Log.v(getString(R.string.app_name),e.getMessage());
    }
}