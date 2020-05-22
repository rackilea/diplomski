private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        exitApp = new JMenuItem("Exit App");
        exitApp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Timer t = new Timer(2000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                JOptionPane.showMessageDialog(getParent(), "Closing App in 2 Seconds");
                t.start();
            }

        });

        fileMenu.add(exitApp);
        menuBar.add(fileMenu);
        return menuBar;
    }