String[] parts = query.split(" ");
int i;
for(i=0; i<query.lenght, i++){
    if(query[i].equals("from") || query[i].equals("FROM")){
        break;
    }
}
String part = parts[i++]; // abc.xyz
parts = part.split(".");
String dbName = parts[0] // db name
String table = parts[1]  // table name