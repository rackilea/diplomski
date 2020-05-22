public DataBaseConnection() {
    try {
        Class.forName(driver);
        this.conn = DriverManager.getConnection(url,user,pwd);
    } 
    catch (ClassNotFoundException e){
        e.printStackTrace();
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
}