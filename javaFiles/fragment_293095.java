TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
Timestamp timestamp = new Timestamp(new Date().getTime());

//Code to insert into database
dataSource = DataSourceFactoryUtil.initDataSource("net.sourceforge.jtds.jdbc.Driver",
PortletProps.get("exampledatabase.db.url"), PortletProps.get("exampledatabase.db.user"),
PortletProps.get("exampledatabase.db.password"), StringPool.BLANK);

connection = dataSource.getConnection();
stmt = connection.createStatement();
String insertQuery = "INSERT INTO [exampletable] ([Firstname], [Lastname], [address], [Time]) VALUES ('"
                        + firstname + "', '" + lastname + "', '" + address + "', '" + timestamp + "')";
stmt.executeUpdate(insertQuery);