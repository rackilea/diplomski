DefaultListModel dlm = new DefaultListModel();
try (PreparedStatement st = con.prepareStatement("select songpick from customer where customername=?")) {
    String customerName = (String)jComboBox1.getSelectedItem();
    st.setString(1, customerName);
    try (ResultSet rs = st.executeQuery()) {
        if (rs.next()) {

            String songpick = rs.getString("songpick");
            dlm.addElement(songpick);

        }
        jList1.setModel(dlm);
    }
} catch (SQLException exp) {
    exp.printStackTrace();
}