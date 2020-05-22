private void createSwingContent(final SwingNode swingNode) {
    SwingUtilities.invokeLater(() -> {
        JButton jButton = new JButton("Click me!");
        jButton.setBounds(0,0,80,50);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(jButton);

        panel.setSize(90, 60);

        swingNode.setContent(panel);

    });
}