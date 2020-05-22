button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        chosenRealm = RealmList.getSelectedItem().toString();
        label2.setText(chosenRealm);


    } //End of actionPerformed