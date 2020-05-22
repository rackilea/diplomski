//Note I changed the classname from EnterLibrary to LibraryMenu. Apparently you
//wanted a LibraryMenu class.
public class LibraryMenu {

    private final int MAX_ITEMS = 50;
    private Library[] videos;
    private int size = 0;

    //remove the static and void keyworkds from this method, so this will be 
    //the constructor.
    public LibraryMenu() {
        videos = new Library[MAX_ITEMS];
        //the rest of your code here...
        switch (scannerObject.nextInt()) {
        //if you're reading an int, keep the constants in the case as int.
        case 1: 
            //no need of brackets inside a case statement
            //check that you can add an item in your Library array
            //also, its not good to ask the user to add 4 (or N) videos in 1 round :).
            if (size < MAX_ITEMS) {
                Library video = addVideo();
                videos[size++] = video;
            }
            break;
        case 2:
            break;
        }
    }

    //remove the static keyword so the instance of your class can call the method.
    public Library addVideo() {
        Library video = new Library();
        //your code to read data goes here...
        //then fulfill the video and return it.
        return video;
    }

    //The Library[] videos is declared in your class, so all other methods could
    //use it without having to receive it as a parameter.
    public void printVidLibrary() {
        //your code goes here...
    }

    public Library searchLibrary() {
        //your code goes here...
    }

    public void deleteVideo( Library[] videos) {
        //your code goes here...
    }

    public static void main(String[] args) {
        new LibraryMenu();
    }
}