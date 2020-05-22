JTextPane textPane = new JTextPane();

  int condition = JComponent.WHEN_FOCUSED;
  InputMap iMap = textPane.getInputMap(condition);
  ActionMap aMap = textPane.getActionMap();

  String enter = "enter";
  iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
  aMap.put(enter, new AbstractAction() {

     @Override
     public void actionPerformed(ActionEvent arg0) {
        System.out.println("enter pressed");
     }
  });