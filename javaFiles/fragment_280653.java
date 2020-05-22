String sql = "SELECT JobID FROM employee WHERE employeeID=" +this.jobID;
ResultSet rs = stmt.executeQuery(sql);
List<String> jobIds = new ArrayList<String>();
while (rs.next()) {
    jobIds.add(rs.getString("JobID"));
}