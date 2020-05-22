System.out.println("- Add Student Info -");
String name = ""; //Get name from user
Date dob = new Date(); //Get DOB from user
String[] friends = new String[]{"Friend1", "Friend2"}; //Get a list of friends from user
String school = ""; //Get school from user

students.add(new Student(name, dob, friends, school));
//OR students.add(0, new Student(name, dob, friends, school)); //Replace 0 with any index