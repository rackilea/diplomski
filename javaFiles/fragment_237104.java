if(natureMP != null) {
    if(natureMP.isPlaying()){
        natureMP.stop();
    }
    else{
        Intent i = new Intent(getApplicationContext(), MusicActivity.class);
        startActivity(i);
    }
}