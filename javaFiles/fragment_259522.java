public List<User> arrangeUsers(String option) {
    String query = "SELECT * FROM ";
    if (searchList.size() > 0) {
        query += "search_results ";
        searchList.clear();
        listChoice = true;
    } else {
        query += "users ";
        users.clear();
        listChoice = false;
    }

    if (option.equals("lastNameAsc")) {
        query += "ORDER BY lastName ASC;";
    } else if (option.equals("lastNameDesc")) {
        query +=  "ORDER BY lastName DESC;";
    } else if (option.equals("dobAsc")) {
        query +=  "ORDER BY dateOfBirth ASC;";
    } else if (option.equals("dobDesc")) {
        query += "ORDER BY dateOfBirth DESC;";
    }
    boolean listChoice;
    try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query);) {
        ResultSet result = stmt.executeQuery();
        while (result.next()) {
            User user = new User();
            user.setFirstName(result.getString("firstName"));
            user.setLastName(result.getString("lastName"));
            user.setDob(result.getDate("dateOfBirth"));
            user.setPhoneNumber(result.getString("phoneNumber"));
            user.setEmail(result.getString("email"));
            user.setUserID(result.getInt("id"));
            if (listChoice) {
                searchList.add(user);
            } else {
                users.add(user);
            }

        }
    } catch (SQLException sqle) {
        System.err.println(sqle);
        sqle.printStackTrace();
        return null;
    }
    if (listChoice) {
        return searchList;
    } else {
        return users;
    }
}