public static JSONObject fetchPersonCarInfo(String person) throws SQLException {

    JSONObject personCarInfoObj = new JSONObject();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
        statement = connection.prepareStatement("SELECT personId, carId, purchaseDate FROM person WHERE person = ?");
        statement.setString(1, person);
        rs = statement.executeQuery();
        JSONArray carsArray = null;
        while (rs.next()) {
            // lookup if we have an entry for personId already in personCarInfoObj
            if (personCarInfoObj.containsKey(rs.getString("personId"))) {
                // build a new object for car info                
                JSONObject personCarObj = new JSONObject();
                carsArray = (JSONArray) personCarInfoObj.get(rs.getString("personId"));
                personCarObj.put("deviceId", (new String(rs.getString("carId"))));
                personCarObj.put("deviceCheckinTime", new Date(rs.getTimestamp("purchaseDate").getTime())); //not sure how to get timestamp column
                // this will append new car info object to the array with key rs.getString("personId"))
                carsArray.add(personCarObj);
                personCarInfoObj.put(rs.getString("personId"), carsArray);
            } else {                    
                carsArray = new JSONArray();
                JSONObject personCarObj = new JSONObject();
                personCarObj.put("deviceId", (new String(rs.getString("carId"))));
                personCarObj.put("deviceCheckinTime", new Date(rs.getTimestamp("purchaseDate").getTime())); //not sure how to get timestamp column
                carsArray.add(personCarObj);
                // store all the cars purchased against that personId in personCarInfoObj
                personCarInfoObj.put(new String(rs.getString("personId")), carsArray);
            }
        }
    } finally {
        statement.close();            
        connection.close();
    }
    return personCarInfoObj;
}