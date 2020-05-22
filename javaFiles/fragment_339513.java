void addKeyBinding(JComponent jc) {
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "esc pressed");
        jc.getActionMap().put("esc pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Esc pressed");
            }
        });

        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true), "esc released");
        jc.getActionMap().put("esc released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Esc released");
            }
        });
}