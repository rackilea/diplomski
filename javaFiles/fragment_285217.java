/**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame frame;
        JMenu jmenu;
        JMenuItem menuItem;
        JMenuBar menuBar;


        frame = new JFrame("Notepad");

            menuBar = new JMenuBar();
            menuBar.setVisible(true);
            jmenu = new JMenu("Test");
            menuItem = new JMenuItem("Open");

            jmenu.add(menuItem);

            JLabel label1 = new JLabel("My Name");
            JButton button1 = new JButton("Button");

            frame.add(label1);
            frame.add(button1);

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(new FlowLayout());
            frame.setSize(660, 350);

                // Set a main menu
                frame.setJMenuBar(menuBar);
                menuBar.add(jmenu);

        frame.setVisible(true);
    }
    }