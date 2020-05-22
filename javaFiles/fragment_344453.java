Statement myStmt = myConn.createStatement();
ResultSet resultSet = myStmt.executeQuery("SELECT * FROM `Employee`");
boolean check = false;
while(resultSet.next()){ 
    if(resultSet.getString("username").matches(textField_1.getText()) && resultSet.getString("password").matches(textField_2.getText())){ 
        System.out.println("Matched!");
        check = true;
        break;
    }

}
if (check == false){

      System.out.println("Invalid username or password!");
}