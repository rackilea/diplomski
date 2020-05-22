public static void main(String[] args){

    String filename = null;
    System.out.println("Type the filename you wish to act upon.");
    Scanner scanIn = new Scanner(System.in);
    filename = scanIn.next();
    Sound sound = new Sound();
    sound.wavRead(fileName);
}