public void init() {
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    setLayout(gridbag);

    c.fill = c.BOTH;

    //c.weightx = 1.0;
    //c.weighty = 1.0;

    c.anchor = c.CENTER;

    c.insets.top = 5;
    c.insets.bottom = 5;
    c.insets.left = 5;
    c.insets.right = 5;

    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.ipadx = 35;
    makebutton("Button1", gridbag, c);

    c.gridx = 2;
    c.gridy = 0;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.ipadx = 0;
    makebutton("Button2", gridbag, c);

    c.gridx = 3;
    c.gridy = 0;
    c.gridheight = 2;
    c.gridwidth = 2;
    c.ipadx = 0;
    makebutton("Button3", gridbag, c);

    c.gridx = 0;
    c.gridy = 1;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.ipadx = 0;
    makebutton("Button4", gridbag, c);

    c.gridx = 1;
    c.gridy = 1;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.ipadx = 35;
    makebutton("Button5", gridbag, c);

    c.gridx = 0;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.ipadx = 0;
    makebutton("Button6", gridbag, c);

    c.gridx = 1;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 2;
    c.ipadx = 35;
    makebutton("Button7", gridbag, c);

    c.gridx = 3;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.ipadx = 0;
    makebutton("Button8", gridbag, c);

    c.gridx = 4;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.ipadx = 0;
    makebutton("Button9", gridbag, c);
}