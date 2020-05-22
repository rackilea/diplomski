class ShowIntro {
 public static void main(String args[]) 
                throws IOException {

    new StoryFrame();
    Scanner reader = new Scanner(new File("Intro.txt"));

    while (reader.hasNext()) {
        StoryFrame.displayText(); // 1 & 2     
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {      
        }
    }
 }
}