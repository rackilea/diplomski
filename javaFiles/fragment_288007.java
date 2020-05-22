String query = "INSERT INTO emp(epfno, fname, lname, sex, nid, address, "
             + "birthday, position, tpno, fathername, mothername, m_status, "
             + "comments, photo_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

st.setInt(1, emp.epfno);
st.setString(2, emp.fname);
st.setString(3, emp.lname);
// etc