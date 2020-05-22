public class AlignToBottom {

public static void main(String[] args) {
    JFrame frame = new JFrame();

    // Settings for the Frame
    frame.setSize(400, 400);
    frame.setLayout(new MigLayout(""));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Parent panel which contains the panel to be docked east
    JPanel parentPanel = new JPanel(new MigLayout("", "[grow]", "[grow]"));

    // This is the panel which is docked east, it contains the panel (bottomPanel) with all the components
    // debug outlines the component (blue) , the cell (red) and the components within it (blue)
    JPanel easternDock = new JPanel(new MigLayout("debug, insets 0", "", "push[]")); 

    // Panel that contains all the components
    JPanel bottomPanel = new JPanel(new MigLayout());


    bottomPanel.add(new JButton("Button 1"), "wrap");
    bottomPanel.add(new JButton("Button 2"), "wrap");
    bottomPanel.add(new JButton("Button 3"), "wrap");

    easternDock.add(bottomPanel, "");

    parentPanel.add(easternDock, "east");

    frame.add(parentPanel, "push, grow");
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

}

}