btnnext.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int i = 0;
        while (i<dataArrayMaxIndex) {
            dataArrayCurrentIndex = i;
            websitetxt.setText(dataArray[i].getWebsitename());
            usernametxt.setText(dataArray[i].getUsername());
            passwordtxt.setText(dataArray[i].getPassword());
            notestxt.setText(dataArray[i].getNotes());
        }
        i++;
    }
});