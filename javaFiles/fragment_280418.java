private void prepareUI() {
        this.setUndecorated(true);
        //Preparing control buttons
        JButton jb = new MyButton("-");
        jb.setActionCommand("Min");
        jb.addActionListener(this);
        jb1 = new MyButton("[]");//delete this line
        jb1.setActionCommand("Max");
        jb1.addActionListener(this);
        JButton jb2 = new MyButton("X");
        jb2.setActionCommand("Close");
        jb2.addActionListener(this);
        //Preparing panel
        JPanel buttonPanel = new JPanel();
        BoxLayout boxLayout1 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(boxLayout1);
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(jb);
        buttonPanel.add(jb1);
        buttonPanel.add(jb2);
        jb.setFocusable(false);
        jb1.setFocusable(false);

        jb2.setFocusable(false);

        JPanel panel=new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.LINE_AXIS);
        panel.setLayout(boxLayout);
        panel.add(Box.createHorizontalGlue())