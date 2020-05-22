public SpecialtyPanel() {
    buildGUI();
}

private void buildGUI() {
    setBorder(BorderFactory.createLineBorder(Color.black));
    JPanel jpaInput = createInputPanel();
    JPanel jpaProcess = createProcessPanel();
    JPanel jpaOutput = createOutputPanel();
    setLayout(new BorderLayout());
    add(jpaInput, BorderLayout.NORTH);
    add(jpaProcess, BorderLayout.CENTER);
    add(jpaOutput, BorderLayout.SOUTH);
}