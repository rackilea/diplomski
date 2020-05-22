class ShowIntro {
 public static void main(String args[]) 
                throws IOException {

    StoryFrame frame = new StoryFrame();                  // Store the StoryFrame in a variable
    Scanner reader = new Scanner(new File("Intro.txt"));

    while (reader.hasNext()) {
        frame.displayText(reader.next());               // pass the text read by the scanner to the displayText() method
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {      
        }
    }
 }
}