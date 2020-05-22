private JPanel createOutputPanel() {
    JPanel jpaOutput = new JPanel();
    jpaOutput.add(pane);
    jpaOutput.setOpaque(false); // panel transparent
    return jpaOutput;
}