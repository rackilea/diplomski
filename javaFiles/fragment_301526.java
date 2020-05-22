private void initComponents() {

    createToolBar = new javax.swing.JToolBar();
    Help = new javax.swing.JButton();
    tabbedPane = new javax.swing.JTabbedPane();
    createMenuBar = new javax.swing.JMenuBar();
    createMenu = new javax.swing.JMenu();
    create = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    createToolBar.setRollover(true);
// Commented for testing only - pls uncomment
//      Help.setIcon(new javax.swing.ImageIcon(getClass().getResource(
//              "/about.png"))); // NOI18N
        Help.setToolTipText(create.getText());
        Help.setFocusable(false);
        Help.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Help.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    createToolBar.add(Help);

    createMenu.setText("File");

    create.setText("Create");
    create.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            createActionPerformed(evt);
        }
    });
    createMenu.add(create);

    createMenuBar.add(createMenu);

    setJMenuBar(createMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
            getContentPane());
    layout.setHorizontalGroup(
        layout.createParallelGroup(Alignment.LEADING)
            .addComponent(createToolBar, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
            .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(createToolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(2)
                .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
    );
    getContentPane().setLayout(layout);

    pack();
}