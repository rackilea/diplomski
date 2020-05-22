Calendar cal = Calendar.getInstance();
Time time = new Time(cal.getTime().getTime());
pst = con.prepareStatement("select * from mytable where t=?");
pst.setTime(1, time);
ResultSet rs = pst.executeQuery();
while (rs.next()) {
    System.out.println(rs.getTime("t"));
}