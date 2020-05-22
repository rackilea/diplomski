for (int i = 1; i <= buttons.length; i++) { // avoid magic numbers

     int btnNumber = (i > 10 && i <= 20) ? (31 - i) : i;

     System.out.printf("i = %d, btnNumber = %d%n", i, btnNumber);
     buttons[btnNumber - 1] = new JButton("label " + btnNumber);
     buttons[btnNumber - 1].setBackground(Color.white);
     panel.add(buttons[btnNumber - 1]);
  }