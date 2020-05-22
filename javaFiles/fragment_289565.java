Statement st = null;
ResultSet rs = null;
Integer userMovedTo = new Integer(0) ;
Integer userMovedBy = new Integer(0);
 try {
        st = conn.createStatement();
        rs = st.executeQuery(query);
        if(rs.next()){
             userMovedTo = rs.getInt("USER_ID");
         }