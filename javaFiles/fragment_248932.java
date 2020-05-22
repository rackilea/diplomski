// first read in the text file and fill the map 2D int array

  for (int row = 0; row < btnGrid.length; row++) {
     for (int col = 0; col < btnGrid[row].length; col++) {
        int value = map[row][col]; // holds value for icons array
        Icon icon = icons[value]; // an array of ImageIcons
        btnGrid[row][col] = new JButton(icon);
        btnGrid[row][col].addActionListener(someListener);
        btnPanel.add(btnGrid[row][col]);
     }
  }