public static JButton MinimizeButton(Loginwards loginwards){
    JButton button = new JButton();
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            // Invoke whatever you need on Loginwards...
            loginwards.doSomething();
        }
    });
    return button;
}