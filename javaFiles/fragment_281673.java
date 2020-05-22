public class Looper {

    static int len = 4;
    static int currentIndex = 0;

    public static void main(String[] args) {

        System.out.println("Index = " + currentIndex);
        for(int i = 0; i < 5; i++){
            movePrev();
        }

    }// main

    public static void movePrev(){
        currentIndex = (currentIndex + len - 1) % len;
        System.out.println("Moved prev. Index = " + currentIndex);
    }

}// Looper