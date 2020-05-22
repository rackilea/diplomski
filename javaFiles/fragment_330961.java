Action exit = new AbstractAction() {
        private static final long serialVersionUID = -2581717261367873054L;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };
exit.putValue(Action.NAME, "Exit");
exit.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);

JButton exitButton = new JButton(exit);
JMenuItem exitItem = new JMenuItem(exit);