myStmt = myConn.prepareStatement(sql);
int col = 1;

Scanner sc = new Scanner(System.in);
System.out.print("Enter number 1: ");
int a= sc.nextInt();
myStmt.setInt(col++, a);

System.out.print("Enter your Name: ");
String firstName = sc.nextLine();
myStmt.setString(col++ , firstName);