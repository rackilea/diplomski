Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("SELECT CSC103 FROM Scores");
java.util.List<Integer> csc103List = new java.util.ArrayList<>();
while (rs.next()) {
    csc103List.add(rs.getInt("CSC103"));
}