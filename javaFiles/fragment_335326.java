try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
    return connection; 
}
/* this is automatically executed:
finally { 
   connection.close(); 
}
*/