String myUserName = myUserNameTextField.getText();
String myPassword = myPasswordTextField.getText();
String myURL = "jdbc:mysql:// " + myIPTextField.getText() + ":" + myPortTextField.getText() + "/DBName"

Class.forName("com.mysql.jdbc.Driver");

c = DriverManager.getConnection(myURL, myUserName, myPassword);