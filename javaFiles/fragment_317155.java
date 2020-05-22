//create an empty action which do nothing
Action emptyAction = new AbstractAction(){
     public void actionPerformed(ActionEvent e)
     {   //do nothing here   }};

//bind F10 with the empty action
KeyStroke f10 = KeyStroke.getKeyStroke( "F10");
frame.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(f10, "F10");
frame.getRootPane().getActionMap().put("F10", emptyAction);