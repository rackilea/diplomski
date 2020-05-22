Connection connection = database.getConnection();
PreparedStatement statement = connection.prepareStatement(myQuery, Statement.RETURN_GENERATED_KEYS);
int count = statement.executeUpdate();
if(count <= 0){
 //value not inserted
}

ResultSet results = statement.getGeneratedKeys();

if(results.next){
 System.out.println(generatedKeys.getLong(1));
}