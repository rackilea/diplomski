JPanel panelFullOfButtons = new JPanel();
    try {
        for (int i = 0; i < projectNames.length; i++) {
            buttons[i] = new ProjectButton(projectNames[i]);
            buttons[i].setId(uniqueIds[i]);

            panelFullOfButtons.add(buttons[i]);
            buttons[i].addActionListener(this);

        }
    } catch (Exception e2) {
        JOptionPane.showMessageDialog(null, e2);
    }