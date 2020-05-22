private class ClickListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UserDAO userDao = new UserDAO();

        if (userDao.login(txtUserName.getText(), txtPassword.getText())) {
            // here you redirect to your main window
        }
        else
            JOptionPane.showMessageDialog(null, "Incorrect user or password!!!");
    }

}