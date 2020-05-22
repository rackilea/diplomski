PreparedStatement statement = con.prepareStatement("update engineers set first_name =? " +
            ",last_name=?, middle_name=?" +
            ",postcode=?,engineer_address=?" +
            ",engineer_dob=?" +
            ",comments=? " +
            "where engineer_id=?"); // <--- WHERE SECTION
statement.setString(1, "Chuck");
statement.setString(2, "Norris");
// and so on and so on...
statement.setInteger(8, idOfEngineer);

statement.executeUpdate();