Connection con = DriverManager.getConnection(sqlUrl, user, pass);
PreparedStatement st = con.prepareStatement(
    "insert into clients values (?, ?, ?, ?, ?)");
st.setString(1, name);
st.setString(2, lname);
st.setString(3, cEmail);
st.setString(4, rate); // Should this really be a string?
st.setString(5, cUrl);
st.executeUpdate();
JOptionPane.showMessageDialog(null, "Data saved!");