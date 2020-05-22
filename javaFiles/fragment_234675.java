JFrame frame = new JFrame();
    frame.setSize(400,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar menu = new JMenuBar();
    frame.setJMenuBar(menu);

    JMenu mainMenu = new JMenu("Menu");
    menu.add(mainMenu);

    File f = new File(PATH_TO_FOLDER);
    if(f.exists()){
        File[] listFiles = f.listFiles();
        for(File file : listFiles){
            if(file.getAbsolutePath().endsWith(EXTENSION)){
                final JMenuItem m = new JMenuItem(file.getName());
                mainMenu.add(m);
                m.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        System.out.println(m.toString());
                    }
                });
            }
        }
    }

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);