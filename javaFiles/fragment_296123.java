public void actionPerformed(ActionEvent e) {
        data = colours.getSelectedIndex();
        Color color = col.getCol(data); // note name change

        // use Color variable, color, somehow here
        mainPanel.setColVals(color);  // something like this perhaps
        mainPanel.repaint();  // to tell the JVM to repaint the JPanel
    }