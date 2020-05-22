int result = pst.executeUpdate();
if (result == 0) {
    statusLabel.setForeground(Color.RED);
    statusLabel.setText("Error Inserting record");
} else {
    statusLabel.setForeground(Color.GREEN);
    statusLabel.setText("Insert Successful");
}