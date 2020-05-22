rs = pst.executeQuery();

if (rs.next()) {
    String add1 = rs.getString("id");
    txt_empid.setText(add1);

    String add2 = rs.getString("Name");
    txt_firstname.setText(add2);

    String add5 = rs.getString("Salary");
    txt_salary.setText(add5);
} else {
    // The query returned no rows - i.e., the given ID doesn't exist in the table.
    // Some error handling is required here
}