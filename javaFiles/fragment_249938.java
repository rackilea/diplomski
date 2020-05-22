Class.forName("com.mysql.jdbc.Driver").newInstance();
String jdbcURL="jdbc:mysql://localhost:3306/jsp";
conn = DriverManager.getConnection(jdbcURL,"root", "");

PreparedStatement psSelectRecord=null;
ResultSet rsSelectRecord=null;
String sqlSelectRecord=null;

sqlSelectRecord="SELECT s.iEmpID, s.sStaffName, s.sStaffDept, s.iStaffPhone,"+
                    "d.sAddress FROM staff_register s " +
                        "left join staff_details d on d.iEmpID=s.iEmpID";    

psSelectRecord=conn.prepareStatement(sqlSelectRecord);
rsSelectRecord=psSelectRecord.executeQuery();