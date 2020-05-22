System.out.println("Enter a year after 1750:");
leapYear = in.nextInt();

while(leapYear < 1750){
     System.out.println("You have entered a year before 1750, please try again :");
     leapYear  = in.nextInt();
}