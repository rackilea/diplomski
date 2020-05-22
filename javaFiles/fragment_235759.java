Scanner userChoice = new Scanner(System.in);
System.out.println("Enter employee ID or full name");
String checkHEmp = "";
int checkHempID = 0;
if(userChoice.hasNextInt())
    checkHempID = userChoice.nextInt();
else 
    checkHEmp += userChoice.nextLine();
if (checkHempID == 3|| checkHEmp.equals("Jill Jones")) {
    //do whatever
}