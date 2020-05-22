JFrame frame = new JFrame();
JPanel panel = new JPanel();
panel.setLayout(new FlowLayout());
JLabel label = new JLabel();
FileSearcher fileSearcher = new FileSearcher(Paths.get("c:\\bla"), ".txt", label);
JButton button = new JButton();
button.setText("next");
button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0) {
        fileSearcher.findNext();
    }});
panel.add(label);
panel.add(button);
frame.add(panel);
frame.setSize(300, 300);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
fileSearcher.start();