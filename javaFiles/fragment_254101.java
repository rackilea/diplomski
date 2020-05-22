Connection con = new DBConnection().connect();  
Class.forName(driver).newInstance();
conn = DriverManager.getConnection(url+dbName,userName,password);

String[] keywords = textArea.getText().split();

for (String keyword: keywords)
{
    createFrame(conn, keyword);    
}