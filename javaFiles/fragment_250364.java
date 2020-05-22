public static void main(String[] args) {
    FrameCreation mainFrame = new FrameCreation();
    JFrame f = new FrameCreation().createFrame(600, 600, "My Frame");
    f.add(mainFrame.createButton(100, 40, 10, 10, "Click me!"));
    f.add(mainFrame.createTextArea(200, 200, 390, 10));
    //This new line
    f.setVisible(true);     
}