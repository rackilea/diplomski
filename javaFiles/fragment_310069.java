public void actionlogin() {
    blogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            String puname = txuser.getText();
            char[] ppaswd = pass.getPassword();
            if (map.keySet().contains(puname) && Arrays.equals(map.get(puname), ppaswd)) {
                JOptionPane.showMessageDialog(null, "Correct Information", "Correct",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Password/ID Found on System",
                        "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                txuser.setText("");
                pass.setText("");
                txuser.requestFocus();

                if (radNew.isSelected()) {
                    if (!puname.equals("") && ppaswd.length > 0) {
                        map.put(puname, ppaswd);
                    }

                    JOptionPane.showMessageDialog(null,
                            "Re-enter your password and ID to confirm", "Information Saved",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    });
}