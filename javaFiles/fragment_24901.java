public JPanel createPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout());
    okButton = new JButton("Ok");
    cancellButton = new JButton("Cancel");
    idTF = new JTextField(10);
    nameTf = new JTextField(10);
    idlbl = new JLabel("ID");
    namelbl = new JLabel("Name");
    panel.add(idlbl);
    panel.add(idTF);
    panel.add(namelbl);
    panel.add(nameTf);
    panel.add(okButton);
    panel.add(cancellButton);
    return panel;
}