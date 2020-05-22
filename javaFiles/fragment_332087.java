while(rs.next()){ 
//Retrieve by column index 
int id = rs.getInt(1); //assume id is at 1st index
int age = rs.getInt(4); //assume age is at 4th index
String first = rs.getString(2); // assume first name is at 2nd index
String last = rs.getString(3); // assume last name is at 3rd index
//Display values 
System.out.print("ID: " + id); System.out.print(", Age: " + age); System.out.print(", First: " + first); System.out.println(", Last: " + last);
System.out.println(" End of one row"); 
}