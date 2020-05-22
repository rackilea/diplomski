for (int x = 0;x<myPanels.length;x++){

        myPanels[x]=new JLabel("");
        myPanels[x].setOpaque(true);
        myPanels[x].setBackground(Color.BLUE);
        myPanels[x].setBorder(BorderFactory.createLineBorder(Color.black));
        myPanels[x].addMouseListener(this); // <-- add same listener to each grid
    }