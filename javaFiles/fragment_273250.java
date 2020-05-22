JFrame frame = new JFrame();
JMenuBar mb = new JMenugBar();
/* here you create all the menu*/ 
char[] password = "123456"; 
JButton button = new JButton("OK");
JPasswordField pf = new JPasswordField();
button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        if(JPasswordField.getPassword.equals(password){
            frame.add(mb);
        }
});
frame.add(pf);
frame.add(button);