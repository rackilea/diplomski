private void createSwingContent(final SwingNode swingNode) {
    SwingUtilities.invokeLater(() -> {
        JButton jButton = new JButton("Click me!");
        // jButton.setBounds(0,0,80,50);

        jButton.setPreferredSize(new Dimension(80, 50));

        JPanel panel = new JPanel();
        // panel.setLayout(null);
        panel.add(jButton);

        swingNode.setContent(panel);

    });
}