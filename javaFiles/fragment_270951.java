button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent event) {

        JPanel _panel = new JPanel();
        _panel.setLayout(new BoxLayout(_panel, BoxLayout.X_AXIS));
        _panel.add(Box.createHorizontalGlue());
        _panel.add(createLabel("Added!"));
        mainPanel.add(_panel);

        mainPanel.validate();
        mainPanel.repaint();
        owner.pack();
    }
})