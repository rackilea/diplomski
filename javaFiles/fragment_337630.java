while(!Arrays.asList(titles).contains(title)){
    System.out.println("Please enter valid Job Title"); 
    title = param.nextLine();
}
System.out.println("Please enter your Hours for this week :");
String count = param.nextLine();
System.out.printf("Your Salary is : $ %f",HoursMath(HourRate(title),Integer.parseInt(count)));