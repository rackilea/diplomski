DateFormat format = new SimpleDateFormat("yyyy/mm/dd");

String query = "INSERT INTO CarOrder VALUES (?, ?, CONVERT(DATE, ?, 111), CONVERT(DATE, ?, 111), ?, ?)";
try (PreparedStatement insert = connection.prepareStatement(query)) {
    insert.setInt(1, CustomerID);
    insert.setDate(2, new Date);
    insert.setDate(3, format.parse(StartDate));
    insert.setDate(4, format.parse(EndDate));
    insert.setDouble(5, HiringPrice);//i think the price is a double maybe you make it int or float so you have to use the right type
    insert.setString(6, Pay);

    insert.executeUpdate();
}