if (rs.next()) {

   String s1 = rs.getString(1);
   String s2 = rs.getString(2);

   // user and pass already match from SQL - no if logic necessary

} else {
     // display GENERIC login failure message
}