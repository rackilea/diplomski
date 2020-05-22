try{
        statement = con.prepareStatement(
                "SELECT * FROM users WHERE Username = ? AND Password =?");
        statement.setString(0,LOGIN_UsernameField.getText());
        statement.setString(0,LOGIN_PasswordField.getPassword());
        ResultSet rs = statement.execute();
        while(rs.next()){
           System.out.println("UserName:"+rs.getString("Username")+"\nPassword:"+rs.getString("Password"));
       } 
}catch(){
 //handle exceptions
}finally{
 //close statements, statement and resultset here..
}