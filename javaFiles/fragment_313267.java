class ToolBar extends JPanel {
    // instance initializer (constructor equivalent)

    public ToolBar() {
        super();
        this.setLayout(myLayout);

        myLayout.setAlignment(FlowLayout.TRAILING);
        JButton[] panelButton = new JButton[5];
        this.setBackground(Color.red);
        this.setBounds(0, 0, 200, 200);

        //Rectangle rec = new Rectangle(330,45,BUTTON, BUTTON);
        //setBounds(rec);
        setPreferredSize(new Dimension(330, 45));

        for (int i = 0; i < 5; i++) {
            Rectangle r = new Rectangle(22, 22);                
            panelButton[i] = new JButton();
            panelButton[i].setText("       ");
            panelButton[i].setIcon(new ImageIcon(view.drawSymbol(i)));
            panelButton[i].setOpaque(true);
            panelButton[i].setBorder(BorderFactory.createLineBorder(Color.black));
            panelButton[i].setBounds(r);
            this.add(panelButton[i]);
            this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            this.setVisible(true);
        }
    }
};