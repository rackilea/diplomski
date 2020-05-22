// time zone with Daylight Time
TimeZone.setDefault(TimeZone.getTimeZone("America/Edmonton"));

// test environment
Statement st = conn.createStatement();
st.execute("CREATE TABLE #tmp (id INT PRIMARY KEY, dt2 DATETIME2)");
st.execute("INSERT INTO #tmp (id, dt2) VALUES (1, '2018-03-11 02:00:00')");
ResultSet rs = st.executeQuery("SELECT dt2 FROM #tmp WHERE id=1");
rs.next();

// test code
LocalDateTime x = rs.getTimestamp("dt2").toLocalDateTime();  // bad

System.out.println(x.toString());