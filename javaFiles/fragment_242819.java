for (int i = 0; i < numButtons.length; i++) {

     // Line (A)
     calcButtons[i].add(ButtonFactory.createButton(numButtons[index], Color.LIGHT_GRAY));
     index++;
     calcButtons[i].addMouseListener(this);
     calcButtons[i].addActionListener(this);
  }

  for (int i = 0; i < operButtons.length; i++) {

     // Line (B)
     calcButtons[i].add(ButtonFactory.createButton(operButtons[index], Color.CYAN));
     index++;
     calcButtons[i].addMouseListener(this);
     calcButtons[i].addActionListener(this);
  }