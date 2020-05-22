import javax.swing.Timer

//...

l_Message.setForeground(Color.green);
l_Message.setText("Succesful Login");
Timer timer = new Timer(3000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        PLOGIN post_login = new PLOGIN();
        post_login.postlogin_UI(login_JFrame);
    }
});
timer.start();