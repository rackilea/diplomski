boolean isSelected = false;
JButton jButton;
void imageClickTest() throws MalformedURLException, IOException {
    final JFrame frame = new JFrame("Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLayout(new BorderLayout());

    final JTabbedPane tabbedPane = new JTabbedPane();

    JPanel pane = new JPanel();
    JButton button;
    pane.setLayout(new BorderLayout());

    button = new JButton("I'm second button");
    button.setIcon(new ImageIcon(ImageIO.read(new URL("http://cdn5.iconfinder.com/data/icons/ie_Financial_set/24/26.png"))));
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if(isSelected) {
                System.out.println("two selected");
                button.setBorder(BorderFactory.createEtchedBorder());
                isSelected = false;
                JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                jSplitPane.add(button);
                jButton.setBorder(BorderFactory.createEtchedBorder());
                jButton.setText("First click me");
                jSplitPane.add(jButton);
                jSplitPane.setDividerLocation(150);
                tabbedPane.addTab("Image Comparision", jSplitPane);
            }
        }
    });
    pane.add(button, BorderLayout.SOUTH);

    button = new JButton("First click me");
    button.setIcon(new ImageIcon(ImageIO.read(new URL("http://cdn4.iconfinder.com/data/icons/REALVISTA/web_design/png/24/testimonials.png"))));
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            button.setText("Now Click on second button.");
            jButton = button;
            isSelected = true;
        }
    });
    pane.add(button, BorderLayout.NORTH);

    button = new JButton("I'm just extra button");
    button.setIcon(new ImageIcon(ImageIO.read(new URL("http://cdn2.iconfinder.com/data/icons/crystalproject/64x64/apps/kservices.png"))));
    button.setEnabled(false);
    pane.add(button, BorderLayout.CENTER);

    tabbedPane.addTab("ImagePane", pane);
    frame.add(tabbedPane, BorderLayout.CENTER);
    frame.setVisible(true);
}