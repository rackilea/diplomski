String sql = "INSERT INTO en_ahmedali VALUES (1, 'text1', 'text1');\nINSERT INTO en_ahmedali VALUES (2, 'text2', 'text2');";
String[] queries = sql.split(";\n"); //Make Sure That Each Statment is seprated with new line.

for(String query : queries){
    db.execSQL(query);
}