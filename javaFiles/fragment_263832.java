public static void main(String[] args) {
    Object grad = UIManager.get("Button.gradient");
    List gradient;
    if (grad instanceof List) {
        gradient = (List) grad;
        System.out.println(gradient.get(0));
        System.out.println(gradient.get(1));
        System.out.println(gradient.get(2));
        System.out.println(gradient.get(3));
        System.out.println(gradient.get(4));
        //gradient.set(2, new ColorUIResource(221, 232, 243));//origal Color
        //gradient.set(2, new ColorUIResource(255, 255, 255));//origal Color
        //gradient.set(2, new ColorUIResource(184, 207, 229));//origal Color
        gradient.set(2, new ColorUIResource(190, 230, 240));
        gradient.set(3, new ColorUIResource(240, 240, 240));
        gradient.set(4, new ColorUIResource(180, 200, 220));
        //UIManager.put("Button.background", Color.pink);
    }
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            new TestButton().makeUI();
        }
    });
}

public void makeUI() {
    JButton button = new JButton("Click");
    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());

    JTabbedPane tab = new JTabbedPane();
    tab.add("Help", createPane(1));
    tab.add("Help", createPane(2));
    tab.add("Help", createPane(3));
    tab.add("Help", createPane(4));
    tab.add("Help", createPane(5));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(tab);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

protected JPanel createPane(int index) {

    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(new JButton("Hello " + index));

    return panel;

}

}