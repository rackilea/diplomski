try {
    String query ="SELECT BUILDING FROM ALLBUILDINGS WHERE BUILDINGNUMBER = ?";
    PreparedStatement st = mysqlConn.prepareStatement(query);
    st.setInt(1,value);

    ResultSet rs = st.executeQuery(query);
    while (rs.next()) {
        value = rs.getString(1);
    }
} catch (Exception ex) {
    System.out.println(ex.getMessage());
}

return value;