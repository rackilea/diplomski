String moduleId = request.getParameter("moduleId").trim();
String temp[] = moduleId.split("/");
for(String s:temp){
    String modId[]=s.split("/");
    PreparedStatement ps = null;
    Connection connection=DatabaseConnection.getConnection();
    ps=connection.prepareStatement("select * from testcase_sahi where module_id=?");
    ps.setString(1,modId[0]);
    ResultSet rs=ps.executeQuery();


    List temporaryList = new ArrayList();  //HERE

    while(rs.next()){
        System.out.println(".............TC ID...."+rs.getString("testcase_id"));
        System.out.println(".............TC Name...."+rs.getString("testcase_name"));
        testCase=rs.getString("testcase_name");

        temporaryList.add(testCase); //HERE

    }

    serializeData(temporaryList) //and HERE

}