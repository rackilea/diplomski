public static void main(String[] args) throws IOException, URISyntaxException {
    URL url = Snake.class.getResource("/WebContent/snake.html");


    File temp = File.createTempfile();
    temp.deleteOnExit();

    // Copy content 

    Desktop.getDesktop().browse(temp.getAbsolutePath());
}