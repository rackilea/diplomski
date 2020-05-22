private class WindowHandler extends WindowAdapter {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("...");
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = getPanelFromScreenPanel(1);
                panel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;

                for (int index = 0; index < 100; index++) {
                    panel.add(new JLabel(Integer.toString(index)), gbc);
                }
                panel.revalidate();
            }
        });
        timer.start();
        timer.setRepeats(false);
    }

}