public void addSong(Song s){
    if(songNumber<10)
    {
       arr[songNumber++] = s;
    }else{
       //what to do if more then 10 songs are added
    }
}