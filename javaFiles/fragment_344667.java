JFileChooser filedlg = new JFileChooser();
    filedlg.showOpenDialog(null);
    File selected = filedlg.getSelectedFile();
    textField.setText(selected.getName());
    textField_1.setText(selected.length());

    String fullName = selected.getAbsolutePath();