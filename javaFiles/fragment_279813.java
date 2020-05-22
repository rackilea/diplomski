public static void method() throws Exception, SQLException{
    try{
        ...
    }catch(Exception ex){
        write ex to file;
    }catch(SQLException sqlex){
        write sqlex to file;
    }
}