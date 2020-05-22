public class Alignments { //Class names should start with an uppercase :)
    private JFrame frame;
    private JPanel leftPanel, rightPanel;

    public static void main(String[] args) {
        //All swing apps must run on their own thread
        SwingUtilities.invokeLater(() -> {
            Alignments align = new Alignments();
        });
    }

    public Alignments() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());

        leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        rightPanel = new JPanel(new FlowLayout());

        leftPanel.setBackground(Color.gray);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.red));

        rightPanel.setBackground(Color.yellow);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN));

        // LEFT AREA BUTTONS
        String[] arry = { "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON",
                "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON",
                "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON",
                "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON",
                "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON",
                "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON",
                "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON",
                "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON",
                "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON",
                "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON",
                "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON",
                "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON", "4000", "FIRST BUTTON", "3", "SECOND BUTTON",
                "40001", "40001", "40001", "40001", "40001", "40001", "40001", "40001", "40001", "40003" };
        for (int i = 0; i < arry.length; i++) {
            JButton button = new JButton(arry[i]);
            leftPanel.add(button);

        }

        String[] arry2 = { "WOW", "MEGA FAIN", "TURBO", "WOW", "MEGA FAIN", "TURBO", "WOW", "MEGA FAIN", "TURBO", "WOW", "MEGA FAIN",
                "TURBO", "WOW", "MEGA FAIN", "TURBO", "WOW", "MEGA FAIN", "TURBO", "WOW", "MEGA FAIN", "TURBO", "WOW", "MEGA FAIN",
                "TURBO", "WOW", "MEGA FAIN", "TURBO" };

        for (int i = 0; i < arry2.length; i++) {
            JLabel labels = new JLabel(arry2[i]);
            rightPanel.add(labels);
        }

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
        splitPane.setDividerSize(0); //User cannot move the divider

        JScrollPane scrollPane = new JScrollPane(splitPane);

        frame.add(scrollPane);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = frame.getWidth() * 70 / 100; //70% of frame's width
                splitPane.setDividerLocation(width);

                Component comp = getComponentWithBiggestHeight(leftPanel);
                if (comp != null) {
                    int trueHeightOfLeftPanel = comp.getBounds().y + comp.getHeight() + 5; //+ some bottom insets? 
                    //Setting splitPane's width to 1 will make it being wrapped horizontally
                    splitPane.setPreferredSize(new Dimension(1, trueHeightOfLeftPanel));
                }
            }
        });
        setDimm();
        frame.setVisible(true);

    }

    private Component getComponentWithBiggestHeight(JPanel panel) {
        Component component = null;
        int max = -1;
        for (Component c : panel.getComponents()) {
            if (c.getBounds().y > max) {
                component = c;
            }
        }
        return component;
    }

    public void setDimm() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(Color.white);
        frame.setLocationRelativeTo(null); //to the center of the screen
    }
}