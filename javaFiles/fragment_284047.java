public String ObtainServerIP(){
String text;

if(MYSQLConnection!=null){
    try{
        PreparedStatement state = MYSQLConnection.prepareStatement("SELECT * FROM "+TableName);
        result = state.executeQuery();
        if (result.next()) {
            text = result.getString("InternetProtocol");
        }
    }catch(Exception e){
        text = e.getMessage();
    }
}
return text;