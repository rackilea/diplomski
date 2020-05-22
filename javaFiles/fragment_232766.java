// new dialog
    JDialog dialog = new JDialog();

    // new label, prints messages if resized or painted
    JLabel label = new JLabel("Test") {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println("Component painted.");
        }
    };
    label.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            System.out.println("Resized: " + e.getComponent().getSize());
        }
    });
    dialog.add(label);        
    System.out.println("Size after new JLabel: " + label.getSize());

    // pack dialog - necessary for setSize/validate to work
    dialog.pack();
    System.out.println("Size after pack: " + label.getSize());                

    // set a size and validate changes sizes
    dialog.setSize(800, 600);
    dialog.validate();
    System.out.println("Size after setSize and validate: " + label.getSize());        

    // set visible would have also done the trick
    dialog.setVisible(true);
    System.out.println("Size after setVisible(true): " + label.getSize());

    // and another resizing (no validation neccessary)
    dialog.setSize(300, 200);

    // dispose
    dialog.dispose();