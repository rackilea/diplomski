public GamePanel() {
    ...
    setFocusable(true); //add this anywhere in this constructor 
}

public MainFrame() {
    ...
    frame.add(gamepanel);
    gamepanel.requestFocusInWindow();
    //add this after adding the panel to your frame and making it visible
}