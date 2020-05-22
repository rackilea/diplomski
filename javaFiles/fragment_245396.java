String sql = "exec vcs_gauge @gauge_name=?,@first_rec_time=?,@last_rec_time=?";
DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
clstmt = con.prepareCall(sql); 
clstmt.setString(1, "vs1_bag");
clstmt.setString(2, df.format(d));
clstmt.setString(3, df.format(currentDate));