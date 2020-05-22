MigLayout thisLayout = new MigLayout("", "[][grow]", "[]20[]");
this.setLayout(thisLayout);
{
    jLabel1 = new JLabel();
    this.add(jLabel1, "cell 0 0");
    jLabel1.setText("jLabel1");
}
{
    JPanel textAreaPanel = new MyPanel(new MigLayout("wrap", "[grow,fill]", "[]"));
    jTextArea1 = new JTextArea();
    textAreaPanel.add(jTextArea1);
    this.add(textAreaPanel, "cell 0 1 2 1,grow,wmin 10");
    jTextArea1.setText("jTextArea1");
    jTextArea1.setLineWrap(false);
}