InputMap  actionMap = (InputMap) UIManager.getDefaults().get("ScrollPane.ancestorInputMap");
actionMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), new AbstractAction(){
    @Override
    public void actionPerformed(ActionEvent e) {
    }});

actionMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), new AbstractAction(){
    @Override
    public void actionPerformed(ActionEvent e) {
    }});