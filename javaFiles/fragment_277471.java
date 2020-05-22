public JButton[] floorButton; // I'm null

public ControlPanel(int x) {
    //...
    for (int i = 0; i < x; i++) { // in
        // Still null
        floorButton[i].add(new JButton("F" + Integer.toString(i)));