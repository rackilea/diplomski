JPanel p = new JPanel();
  JTextField familyName = new JTextField(10);
  JTextField firstName = new JTextField(10);

  p.add(new JLabel("Family name :"));
  p.add(familyName);
  p.add(new JLabel("First name : "));
  p.add(firstName);

  JOptionPane.showConfirmDialog(null, p, "Family and first name : ", JOptionPane.OK_CANCEL_OPTION);