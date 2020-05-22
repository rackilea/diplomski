if (result.next()) {
    CreateGUI.main(null);
    System.out.println(username);
} else {
    JOptionPane.showMessageDialog(null, "Invalid username or password!", "ERROR", JOptionPane.WARNING_MESSAGE);
}