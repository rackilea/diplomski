public adminMenu(int[] c) {

    initComponents();
    coinCount = c;
    int amount200p = coinCount[7]/200;
    JOptionPane.showMessageDialog(null, amount200p);
    coin200.setText("£2: " + Integer.toString(amount200p) + " coins");
}