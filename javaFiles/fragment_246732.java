// renamed from Hangman
public class Main {
    public static void main(String[] args) {

        // removed need for JFrame as no GUI is actually used.
        Hangman hangman = new Hangman();
        // starting a thread with the hangman runnable
        new Thread(hangman).start();

        // main thread will end here, but the hangman thread will keep the program running. 
    }
}