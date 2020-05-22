public DBConnection(String host, String name, String user, String password, String query, String column){
        this.host = host;
        this.name = name;
        this.user = user;
        this.password = password;
        this.query = query;
        this.column = column;
        this.hostcompleto = "jdbc:mysql://"+host+":3306/"+name;
    }