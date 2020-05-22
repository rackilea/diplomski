public GridBagConstraintsFrame() {
    Container c = getContentPane();
    JPanel p = new JPanel(new GridBagLayout());
    c.setLayout(new BorderLayout());

    {
        JButton button1 = new JButton("Button 1");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = gbc.HORIZONTAL;
        p.add(button1, gbc);
    }

    {
        JButton button2 = new JButton("Button 2");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = gbc.HORIZONTAL;
        p.add(button2, gbc);
    }

    {
        JButton button3 = new JButton("Button 3");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        p.add(button3, gbc);
    }

    {
        JButton button3 = new JButton("Button 4");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        p.add(button3, gbc);
    }

    {
        JButton button3 = new JButton("Button 5");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        p.add(button3, gbc);
    }

    {
        JButton button3 = new JButton("Button 6");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        p.add(button3, gbc);
    }

    {
        JButton button3 = new JButton("Button 7");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        p.add(button3, gbc);
    }

    {
        JButton button3 = new JButton("Button 8");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        p.add(button3, gbc);
    }

    {
        JButton button3 = new JButton("Button 9");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        p.add(button3, gbc);
    }

    {
        JButton button3 = new JButton("Button 10");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        p.add(button3, gbc);
    }

    c.add(p, BorderLayout.CENTER);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Gridbag constraints.");
    pack();
    setVisible(true);
}