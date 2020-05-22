String query = "delete from students where firstName=? and lastName=? and age=?";
try (PreparedStatement delete = connection.prepareStatement(query)) {

    delete.setString(1, firstName);
    delete.setString(2, lastName);
    delete.setInt(3, age);//<-----------(1)

    delete.executeUpdate();
}