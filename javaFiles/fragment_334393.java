JButton editName= new JButton ("Edit Name");
editName.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            JFrame nameframe= new JFrame("Name Edit");
            name2 = JOptionPane.showInputDialog(nameframe, "Change name to: ");
            guest.setName(name2);
            filler.setText(guest.toString())
        }
    });