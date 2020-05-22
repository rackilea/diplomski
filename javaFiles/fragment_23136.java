Scanner keyboardIn = new Scanner(System.in);
String[] days = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday","Friday", "Saturday", "Sunday"}; 

System.out.print ("Enter the number of the day you want: ");
int number = keyboardIn.nextInt()-1;
if (number<days.length && number>=0){
    System.out.println(days[number]);
}else{
    System.out.println("Invalid number of day of the week");
}