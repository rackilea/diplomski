private JPanel homePanel() {
    JPanel home = new JPanel();
    home.setLayout(null);
    home.setBackground(Color.DARK_GRAY);
    String greeting = 
      workingStudent==null?"Hello, unknown user":"Hello, "+workingStudent.getName();
    JLabel hi = new JLabel(greeting);
    hi.setSize(400, 100);
    hi.setLocation(10,10);
    hi.setFont(new Font("Serif", Font.BOLD, 36));
    hi.setForeground(Color.WHITE);

    home.add(hi);

    return home;

}