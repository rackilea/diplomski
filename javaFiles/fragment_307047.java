public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setVisible(true);
    int result = JOptionPane.showConfirmDialog(null, "AA");
    System.out.println(result);
    if (result == JOptionPane.CLOSED_OPTION)
        System.exit(0);
}