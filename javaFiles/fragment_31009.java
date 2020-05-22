public static void key(JComponent component) {
    Action test = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("w has been pressed");
        }
    };
    component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "test");
    component.getActionMap().put("test", test);

}