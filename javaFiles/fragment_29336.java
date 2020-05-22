class Database{
    Connection jdbc;
    //Can store username, url , password etc as private fields here
    private Database(){
        if(jdbc == null){
            Class.forName("org.h2.Driver");
            jdbc = DriverManager.getConnection("URL", "sa", "");
        }
    }
    Connection getConnection(){
        if(jdbc == null){
            this();
        }
        return jdbc;
    }
};