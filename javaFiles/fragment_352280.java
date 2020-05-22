public OracleBean()
{
    driver = "oracle.jdbc.driver.OracleDriver";
    url = "jdbc:oracle:thin:@localhost:1521:xe";
    dbName = "Test";
    dbUsername = "username";
    dbPassword = "password";
    connect = null;

    Method = new OracleMethods();
}

public String getColorData(String rowID, int col)
{
    connect = Method.openConnection(driver, url, dbName, dbUsername, dbPassword);