jdbcTemplate.query("SELECT Employee_Name, Employee_Age FROM Employee WHERE Employee_ID=1", (ResultSet rs) -> {
    HashMap<String,String> results = new HashMap<>();
    while (rs.next()) {
        results.put(rs.getString("Employee_Name"), rs.getString("Employee_Age"));
    }
    return results;
});