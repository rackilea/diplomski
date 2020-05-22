public static void main(String[] args) {

    JFrame window = new JFrame("Test");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(300, 300);


    JPanel innerPanel = new JPanel(new BorderLayout());


    JPanel panelUp = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelDown = new JPanel();

    window.add(innerPanel, BorderLayout.NORTH);
    window.add(panelDown, BorderLayout.CENTER);

    innerPanel.add(panelUp, BorderLayout.NORTH);
    innerPanel.add(panelCenter, BorderLayout.SOUTH);

    panelUp.setBackground(new Color(200, 240, 200));
    panelCenter.setBackground(new Color(240, 200, 200));
    panelDown.setBackground(new Color(200, 200, 240));

    panelUp.setPreferredSize(new Dimension(panelUp.getWidth(), 50));
    panelCenter.setPreferredSize(new Dimension(panelCenter.getWidth(), 100));
    panelDown.setPreferredSize(new Dimension(panelDown.getWidth(), window.getHeight() - 150));

    window.setVisible(true);
}