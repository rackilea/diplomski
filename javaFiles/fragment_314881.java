// create new model for your comboBox
DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

// fill model with data
try (Connection con = /*get connection to your db by any means necessary*/;
    PreparedStatement stmt = con.prepareStatement(/*your query*/);
    ResultSet rs = stmt.executeQuery();) {

    while (rs.next()) {
        model.addElement(rs.getString(/*your column*/));
    }

    comboBox.setModel(model); // set model for your JComboBox

} /*catch and all that*/
// no need for finally because try-with-resources.