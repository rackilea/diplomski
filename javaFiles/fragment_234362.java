@Test
public void testUpdateCompany() {
  CompanyDao companyDao = new CompanyDao();
  IDatabaseConnection dbConn = createConnection();

  IDataSet dataSet = createDataSet("CompanyDataSet.xml");
  DatabaseOperation.CLEAN_INSERT.execute(dbConn, dataSet);

  companyDao.updateCompany(100, "NewName");

  IDataSet actual = dbConn.createDataSet(new String[]{"company"});
  ITable companyTable = actual.getTable("company");

  assertEquals("NewName", companyTable.getValue(0, "company_name"));
}