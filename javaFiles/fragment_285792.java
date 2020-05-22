private void loadList(ComboBox<String> combobox, String value) {
    combobox.getItems().setAll(getCorrespondingList(value));
}

public List<String> getCorrespondingList(String value) {
    ArrayList<String> list = new ArrayList<String>();
    try {
        // use PreparedStatement's placeholder functionality to avoid
        // issues with quotes inside the string
        String query = "SELECT ... WHERE Item = ? ORDER BY c";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, value);

        // no need to keep this after the method exits
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(rs.getString(1));
        }
    } catch (SQLException e) {
        e.printStackTrace(System.err); // should provide more info in case an exception happens
    }
    return list;
}