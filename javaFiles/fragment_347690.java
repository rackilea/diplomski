Scanner input = new Scanner(System.in);
System.out.println("Please enter Specify the contact type (1 Personal, 2 Business) : ");
int contactType = input.nextInt();

//collect data common to both types
if(contactType == 1){
   //collect information specific to personal
} else if(contactType ==2){
   //collect information specific to business
}