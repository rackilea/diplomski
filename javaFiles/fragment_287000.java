if (n == JOptionPane.YES_OPTION) {
     ConfirmBooking CB = new ConfirmBooking(ID);
     dispose();
     CB.setLocationRelativeTo(null);
     CB.setVisible(true);
}