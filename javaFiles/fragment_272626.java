ActionListener listener = new MyListener();

  for (int i = 0; i < leftBtns.length; i++) {
     for (int j = 0; j < leftBtns[i].length; j++) {
        JButton btn = new JButton("L" + i + j);
        btn.setFont(btn.getFont().deriveFont(Font.BOLD, BTN_FONT_SIZE));
        btn.addActionListener(listener);
        leftPanel.add(btn);
     }
  }