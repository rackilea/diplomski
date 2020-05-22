Statement stmt = conn.createStatement();  
ResultSet rs = stmt.executeQuery("SELECT min(val1), min(val2), min(val3) FROM SCORE");

if (rs.next()) {
    minValue = DoubleStream.of(
            rs.getDouble(1), rs.getDouble(2), rs.getDouble(3)
    ).min().getAsDouble();
}