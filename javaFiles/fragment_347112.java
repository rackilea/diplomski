String Username = "user";
String Password = "pass";

List<String> myList = new ArrayList<>(); 
myList.add("user");
myList.add("pass");

System.out.println(Username);
System.out.println(Password);
System.out.println(myList.get(0));
System.out.println(myList.get(1));
System.out.println(Username.equals(myList.get(0)));
System.out.println(Password.equals(myList.get(1)));

if (Username.equals(myList.get(0)) && Password.equals(myList.get(1))) {
    System.out.println("Hello, " + Username);
}