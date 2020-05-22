public void createGUI() {
    initFrame();
    initPanel(); //put your initButtons() method here
    pc = new paintComponent();
    panel.add(button1); //these could go in initPanel() too
    panel.add(button2); //^
    frame.add(pc, BorderLayout.CENTER);//your JFrame has a default layout of BorderLayout.
    frame.add(panel, BorderLayout.PAGE_START);
}