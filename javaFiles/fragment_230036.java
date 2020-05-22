String params = "?, ?, ?, ?"; //you will have to generate enough of these yourself
                              //This is an exercise for you!

String sql = "SELECT xua.XUAID, xua.XUA01, xua.XUA02 "
            + "FROM dbo.XDSysUseArea xua "
            + "WHERE xua.XUA03 IN (" + params + ")";

conn = ds.getConnection();
ps = conn.prepareStatement(sql);

int index = 1;

for(HotelSource org : orgList) {
    ps.setString(index, org.getPrimaryKey());
    //           ^^^^^ use index here

    index++;
}

rs = ps.executeQuery();
while (rs.next()) {
    // do sth
}