private boolean CheckEmployee(long bDays) throws ClassNotFoundException, SQLException {


        PreparedStatement preparedStatement;

        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(url, userName, password);

        String selectProject = null;

        if(getTypeOfTimeOff().equalsIgnoreCase("Vacation Day"))
            selectProject = "SELECT VacationDay As dayList FROM EmpVacationTbl Where FullName =? "
                + "AND ManagerName =?";

        else if(getTypeOfTimeOff().equalsIgnoreCase("Bonus Day"))
            selectProject = "SELECT BonusDay As dayList FROM EmpVacationTbl Where FullName =? "
                    + "AND ManagerName =?";

        else if(getTypeOfTimeOff().equalsIgnoreCase("Birthday Day"))
            selectProject = "SELECT BirthdayDay As dayList FROM EmpVacationTbl Where FullName =? "
                + "AND ManagerName =?";

        System.out.println("Query String : " + selectProject);

        preparedStatement = conn.prepareStatement(selectProject);

        preparedStatement.setString(1, getEmpName());
        preparedStatement.setString(2, getManagerName());

        System.out.println(preparedStatement.toString());

        try (ResultSet rs = preparedStatement.executeQuery()) 
        {
            while (rs.next()) 
            {
                int checker = 0 ;
                checker = rs.getInt("dayList");
                System.out.println("Days the user has off are: " + checker );

                if(checker < bDays)
                {
                    conn.close();
                    message = "Too many days";
                    return false;
                }
                else
                {
                    conn.close();
                    return true;
                }
            }

            if (rs.wasNull()) {
                {
                    conn.close();
                    message = "Unable to find the days";
                    return false;
                }
            }
        }
        conn.close();
        message = "Information not matching recordings.";
        return false;
}