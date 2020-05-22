public static void main(String[] args) throws InterruptedException {
    MultiFontField text = new MultiFontField();
    JFrame frame = new JFrame();

    text.appendText("Hello ", "Times New Roman").appendText("world!", "Courier").finaliseText();

    frame.add(text);
    frame.setSize(200, 50);     
    frame.setVisible(true);
}