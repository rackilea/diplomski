private ScriptEditor() {

    setBackground(Color.WHITE);

    JPanel outerPanel = new JPanel();

    lineNumPanel = new LineNumberPanel();

    scriptArea = new JTextArea();
    scriptArea.setLineWrap(true);
    scriptArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
    scriptArea.setMargin(new Insets(3, 10, 0, 10));

    outerPanel.add(lineNumPanel, BorderLayout.WEST)
    outerPanel.add(scriptArea, BorderLayout.CENTER)

    JScrollPane scrollPane = new JScrollPane(outerPanel);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setPreferredSize(new Dimension(width, height));

    scriptArea.addKeyListener(this);

    add(lineNumPanel);
    add(scrollPane);
}