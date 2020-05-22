btnSubmit.addActionListener(new ActionListener() {
    int curentIndex = -1;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            curentIndex = (curentIndex + 1) % myIcons.length;
            lblImage.setIcon(myIcons[curentIndex]);
        }
    }
}