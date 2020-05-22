JLabel label = new JLabel("a");
label.setBounds(146, 184, 131, 20);
frame.getContentPane().add(label);

JButton btnAdd = new JButton("Add");
btnAdd.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

    String a = textFielda.getText();
    String b = textFieldb.getText();
    int A = Integer.parseInt(a);
    int B = Integer.parseInt(b);
    int C = A + B;
    String c = Integer.toString(C);
    label.setText(c);
    }
    });