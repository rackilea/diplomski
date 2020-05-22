btnnext.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<dataArrayMaxIndex; i++) {
            dataArrayCurrentIndex = i;
            websitetxt.setText(dataArray[i].getWebsitename());
            usernametxt.setText(dataArray[i].getUsername());
            passwordtxt.setText(dataArray[i].getPassword());
            notestxt.setText(dataArray[i].getNotes());
        }
    }
});