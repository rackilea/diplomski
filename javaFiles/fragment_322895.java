public class Library{

    private Song[] arr = new Song[10];
    private int songNumber = 0; //the number of Songs already stored in your array

    public void addSong(Song s){
        arr[songNumber++] = s;
    }
}